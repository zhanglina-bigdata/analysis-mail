package com.niu.mail.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户邮箱表
 * </p>
 *
 * @author zhengzz
 * @since 2020-01-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MyMailUser对象", description="用户邮箱表")
@TableName("my_mail_user")
@ToString
public class MyMailUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "用户邮箱")
    private String userMail;
    @ApiModelProperty(value = "用户密码")
    private String mailPassword;
    @ApiModelProperty(value = "用户认证码")
    private  String userConfirmSecret;
    @ApiModelProperty(value = "逻辑删除键")
    @TableLogic
    private Boolean isDelete;


}
