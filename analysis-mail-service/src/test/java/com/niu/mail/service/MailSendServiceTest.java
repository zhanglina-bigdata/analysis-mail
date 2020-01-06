package com.niu.mail.service;

import com.niu.analysis.mail.domain.vo.request.EmailRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: analysis-mail
 * @description:
 * @author: zhengzz
 * @create: 2020-01-06 13:51
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MailSendServiceTest {
    @Autowired
    private MailSendService mailSendService;
    @Test
    public  void testSendEmail() {
        EmailRequest email=new EmailRequest().builder().toUsers(new String[]{"1","2"}).secUsers(new String[]{"1"}).fromUser("1").mailServerId("1").build();
        email.setTitle("测试邮件");
        email.setContent("1、医院里，一孕妇难产，医生灵机一动，给她服用了益生菌。\n" +
                "2、300斤的某女没看到她老公躺在沙发上，一屁股把他坐死了。法律并没有追究她的责任，因为法不责重。\n" +
                "3、两个老人去养老院。。。\n" +
                "70岁的老人进去了，90岁老人没进去。\n" +
                "工作人员：“对不起，大爷，我们不接受儿女健在的老人。您的资料显示，你有一个儿子。”\n" +
                "90岁老人：“操，刚刚进去的就是我儿子！ ”\n" +
                "4、和哥们去一个经常去的小饭馆吃饭，因为经常去所以特别熟！吃完饭结账时104块钱，我和老板说：打个把零抹了吧？\n" +
                "......");
        mailSendService.sendEmail(email);
    }
}
