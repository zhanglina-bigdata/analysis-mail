package com.niu.mail.util;

import com.niu.analysis.mail.domain.dto.EmailPropsInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @program: analysis-mail
 * @description:
 * @author: zhengzz
 * @create: 2020-01-06 11:20
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailUtil {

    private EmailPropsInfo info;
    private Properties prop;
    private  Session session;

    public EmailUtil(EmailPropsInfo info) {
        this.info = info;
        setProp();
    }

    private void setProp() {
        if(prop==null) {
            prop = new Properties();
        }
        //做链接前的准备工作  也就是参数初始化
        this.prop.setProperty("mail.smtp.host",info.getMailHost());//发送邮箱服务器
        this.prop.setProperty("mail.smtp.port",info.getSmtpPort().toString());//发送端口
        this.prop.setProperty("mail.smtp.auth",info.getSmtpAuth().toString());//是否开启权限控制
        this.prop.setProperty("mail.debug","true");//true 打印信息到控制台
        this.prop.setProperty("mail.transport",info.getMailProtocol());//发送的协议是简单的邮件传输协议
        this.prop.setProperty("mail.smtp.ssl.enable","true");

        createSession();


    }
    private void createSession() {
        //建立两点之间的链接
        Session session = Session.getInstance(this.prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //"udpdyeytruycdjda"
                return new PasswordAuthentication(info.getFromUser(),info.getAuthNo());
            }
        });
        this.session =session;
    }
    public void sendSimpleEmail(String title,String Content) {
        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        try {
            message.setFrom(new InternetAddress(info.getFromUser()));
            //设置收件人
            List<InternetAddress> toUsers= info.getToUser().stream().map(str->{
                InternetAddress address= null;
                try {
                    address = new InternetAddress(str);
                } catch (AddressException e) {
                    e.printStackTrace();
                }
                return  address;
            }).parallel().collect(Collectors.toList());
            message.addRecipients(Message.RecipientType.TO,toUsers.toArray(new InternetAddress[toUsers.size()]));
            //设置主题
            message.setSubject(title);
            //设置邮件正文  第二个参数是邮件发送的类型
            message.setContent(Content,"text/html;charset=UTF-8");
            message.setSentDate(new Date());
            //发送一封邮件
            Transport transport = session.getTransport();
            transport.connect(info.getFromUser(),info.getAuthNo());
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
