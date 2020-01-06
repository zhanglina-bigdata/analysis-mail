package com.niu.mail.service;

import com.niu.analysis.mail.domain.dto.BaseDTO;
import com.niu.analysis.mail.domain.dto.MailServerDTO;
import com.niu.analysis.mail.domain.vo.request.EmailRequest;
import org.springframework.stereotype.Service;
/**
 * @program: analysis-mail
 * @description: 邮件处理
 * @author: zhengzz
 * @create: 2019-12-27 09:31
 **/
@Service
public interface MailSendService {

    BaseDTO<MailServerDTO> sendEmail(EmailRequest emailRequest);
}
