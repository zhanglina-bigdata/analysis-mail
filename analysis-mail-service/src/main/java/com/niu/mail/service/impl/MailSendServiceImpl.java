package com.niu.mail.service.impl;

import cn.hutool.core.bean.copier.BeanCopier;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niu.analysis.mail.domain.dto.BaseDTO;
import com.niu.analysis.mail.domain.dto.EmailPropsInfo;
import com.niu.analysis.mail.domain.dto.MailServerDTO;
import com.niu.analysis.mail.domain.vo.request.EmailRequest;
import com.niu.interfaces.sequence.service.EmailSequenceService;
import com.niu.mail.entity.MyMailServer;
import com.niu.mail.entity.MyMailUser;
import com.niu.mail.mapper.MyMailServerMapper;
import com.niu.mail.mapper.MyMailUserMapper;
import com.niu.mail.service.MailSendService;
import com.niu.mail.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: analysis-mail
 * @description:
 * @author: zhengzz
 * @create: 2020-01-03 12:52
 **/
@Service
public class MailSendServiceImpl implements MailSendService {

    @Autowired
    private EmailSequenceService serverService;

   @Autowired
   private MyMailUserMapper mailUserMapper;

   @Resource
   private RedisTemplate<String, Object> redisTemplate;

   @Autowired
   private MyMailServerMapper mailServerMapper;
    @Override
    public BaseDTO<MailServerDTO> sendEmail(EmailRequest request) {
        // 1. 查询发件人
        MyMailUser fromUser=mailUserMapper.selectOne(new QueryWrapper<MyMailUser>().eq("id",Integer.parseInt(request.getFromUser())));
        // 2. 查询接收人
       List<String> toUsers= mailUserMapper.selectList(new QueryWrapper<MyMailUser>().in("id",request.getToUsers())).stream().filter(myMailUser -> {return myMailUser.getIsDelete()==false;})
               .map(myMailUser -> {
           return myMailUser.getUserMail();
       }).collect(Collectors.toList());
       // 3.抄送人
       List<String> secUsers= mailUserMapper.selectList(new QueryWrapper<MyMailUser>().in("id",request.getToUsers())).stream().filter(myMailUser -> {return myMailUser.getIsDelete()==false;})
               .map(myMailUser -> {return myMailUser.getUserMail();})
               .collect(Collectors.toList());
       // 4.查询邮件主机类型
        String value= (String) redisTemplate.opsForValue().get("email_"+request.getMailServerId());
       // 组装并发送邮件
       MyMailServer server= JSON.parseObject(value, MyMailServer.class);
        EmailPropsInfo info = new EmailPropsInfo();
        BeanCopier.create(server,info, CopyOptions.create().setIgnoreCase(true).setIgnoreNullValue(false)).copy();
        info.setFromUser(fromUser.getUserMail());
        info.setAuthNo(fromUser.getUserConfirmSecret());
        info.setToUser(toUsers);
        info.setSecUser(secUsers);
        new EmailUtil(info).sendSimpleEmail(request.getTitle(),request.getContent());
        return new BaseDTO<MailServerDTO>().setResult(null);

    }
}
