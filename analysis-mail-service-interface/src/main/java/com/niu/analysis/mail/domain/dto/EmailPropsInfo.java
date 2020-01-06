package com.niu.analysis.mail.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: analysis-mail
 * @description:
 * @author: zhengzz
 * @create: 2020-01-06 14:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailPropsInfo {
    @ApiModelProperty(value = "邮件服务器host")
    private String mailHost;

    @ApiModelProperty(value = "协议")
    private String mailProtocol;

    @ApiModelProperty(value = "是否需要smtp认证")
    private Boolean smtpAuth;

    @ApiModelProperty(value = "服务器端口")
    private Integer smtpPort;

    private Boolean ttlEnable;

    private Boolean sslEnable;

    private String fromUser;

    private List<String> toUser;

    private List<String> secUser;

    private String authNo;

}
