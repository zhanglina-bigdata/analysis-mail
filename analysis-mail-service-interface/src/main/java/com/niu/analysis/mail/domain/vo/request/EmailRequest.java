package com.niu.analysis.mail.domain.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @program: analysis-mail
 * @description:
 * @author: zhengzz
 * @create: 2020-01-05 22:24
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("邮件请求报文")
@Builder
public class EmailRequest {
    @ApiModelProperty("发送者")
    private String fromUser;
    @ApiModelProperty("接收人")
    private String[] toUsers;
    @ApiModelProperty("密送人")
    private String[] secUsers;
    @ApiModelProperty("邮件类型")
    private Integer type;
    @ApiModelProperty("邮件标题")
    private String title;
    @ApiModelProperty("邮件内容")
    private String content;
    @ApiModelProperty("邮件引用内容")
    private String contentRefrence;
    @ApiModelProperty("附件列表")
    private  String[] attaches;
    @ApiModelProperty("邮件主机id")
    private String mailServerId;
    @ApiModelProperty("记录日志目的地")
    private Integer[] destLog;


}
