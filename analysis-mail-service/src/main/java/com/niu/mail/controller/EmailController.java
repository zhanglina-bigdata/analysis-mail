package com.niu.mail.controller;

import com.niu.analysis.mail.domain.dto.MailServerDTO;
import com.niu.analysis.mail.domain.vo.request.EmailRequest;
import com.niu.analysis.mail.domain.vo.response.BaseResponse;
import com.niu.mail.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: analysis-mail
 * @description:
 * @author: zhengzz
 * @create: 2020-01-03 13:07
 **/
@RestController
public class EmailController {
    @Autowired
    private MailSendService mailService;
    /****
    * @Description: 发送邮件
    * @Param: [emailRequest]
    * @return:
    * @Author:
    * @Date: 2020/1/3
    */
    @RequestMapping("/send/email")
    public BaseResponse<MailServerDTO> sendEmail(@RequestBody EmailRequest emailRequest) {
        MailServerDTO dto=mailService.sendEmail(emailRequest).getResult();
       return new BaseResponse<MailServerDTO>().setResult(dto).setCode(200).setMsg("ss");
    }

   /* *//****
    * @Description: 发送模板邮件
    * @Param: [tempId]
    * @return:
    * @Author:
    * @Date: 2020/1/3
    *//*
    @RequestMapping("/send/email")
    public String sendEmail(@RequestParam("id") String tempId) {
        return mailService.sendEmail();
    }*/

}
