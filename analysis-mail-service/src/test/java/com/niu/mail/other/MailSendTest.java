package com.niu.mail.other;

import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @program: analysis-mail
 * @description: QQ邮件测试服务
 * @author: zhengzz
 * @create: 2020-01-05 22:44
 **/
public class MailSendTest {
    @Test
    public void SendMail(){
        //做链接前的准备工作  也就是参数初始化
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host","smtp.qq.com");//发送邮箱服务器
        properties.setProperty("mail.smtp.port","465");//发送端口
        properties.setProperty("mail.smtp.auth","true");//是否开启权限控制
        properties.setProperty("mail.debug","true");//true 打印信息到控制台
        properties.setProperty("mail.transport","smtp");//发送的协议是简单的邮件传输协议
        properties.setProperty("mail.smtp.ssl.enable","true");
        //建立两点之间的链接
        System.out.println("执行了2");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("2570389155@qq.com","udpdyeytruycdjda");
            }
        });
        System.out.println("执行了3");
        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        try {
            message.setFrom(new InternetAddress("2570389155@qq.com"));

            //设置收件人
            message.setRecipient(Message.RecipientType.TO,new InternetAddress("1205983855@qq.com"));//收件人
            //设置主题
            message.setSubject("验证码");
            //设置邮件正文  第二个参数是邮件发送的类型
            message.setContent("牛牛","text/html;charset=UTF-8");

            //发送一封邮件
            Transport transport = session.getTransport();
            transport.connect("2570389155@qq.com","udpdyeytruycdjda");
            Transport.send(message);
            System.out.println("执行了");
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
