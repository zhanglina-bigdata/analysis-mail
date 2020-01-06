package com.niu.mail.config;

import com.alibaba.fastjson.JSON;
import com.niu.mail.entity.MyMailServer;
import com.niu.mail.mapper.MyMailServerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @program: analysis-mail
 * @description:
 * @author: zhengzz
 * @create: 2020-01-05 23:36
 **/
@Slf4j
public class EmailServerCacheLoader {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private MyMailServerMapper mailServerMapper;
    @PostConstruct
    private  void loadMailServerInfo() {
        log.info("load email server info into cache ");
        List<MyMailServer> servers=mailServerMapper.listMailServerInfo();
        log.info(servers.size()+"");
       servers.stream().filter(myMailServer -> {
           try {
               log.info(myMailServer.toString());
           if (myMailServer.getIsDelete().booleanValue() == false) {
               String key = "email_"+myMailServer.getMailServerType().getMailServerId();
               log.info("loading into cache:"+"the key is "+key);
               redisTemplate.opsForValue().set(key, JSON.toJSONString(myMailServer,false));
               return true;
           }
           }catch (Exception ex) {
               ex.printStackTrace();
               log.error("loading fail ");
                 System.exit(1);
           }
           return false;
       }
       ).toArray();
    }
}
