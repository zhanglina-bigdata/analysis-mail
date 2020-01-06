package com.niu.mail.other;

import com.alibaba.fastjson.JSON;
import com.niu.mail.entity.MyMailServer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: analysis-mail
 * @description: redis测试
 * @author: zhengzz
 * @create: 2020-01-05 23:27
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTemplateTest {
    @Resource
    RedisTemplate redisTemplate;
    @Test
    public void testGetAndSet() {
        redisTemplate.opsForValue().set("qq_server","QQ");
      String value= (String) redisTemplate.opsForValue().get("1");
        MyMailServer server = JSON.parseObject(value,MyMailServer.class);
      log.info(server.toString());

    }
}
