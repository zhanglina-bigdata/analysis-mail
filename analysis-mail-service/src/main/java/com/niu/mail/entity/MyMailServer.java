package com.niu.mail.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 常用邮件应用
 * </p>
 *
 * @author zhengzz
 * @since 2020-01-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MyMailServer对象", description="常用邮件应用")
@ToString
public class MyMailServer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "邮件业务键")
    private Integer mailId;

    @ApiModelProperty(value = "邮箱类型id")
    private Integer mailTypeId;

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

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    @ApiModelProperty(value = "操作用户")
    private String optUser;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除键")
    private Boolean isDelete;

    @ApiModelProperty(value = "邮箱服务器类型")
    @TableField(exist = false)
    private MailServerType mailServerType;
}
