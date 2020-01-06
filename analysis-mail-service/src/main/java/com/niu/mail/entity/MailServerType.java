package com.niu.mail.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 邮箱服务器类型表
 * </p>
 *
 * @author zhengzz
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MailServerType对象", description="邮箱服务器类型表")
@TableName("mail_server_type")
public class MailServerType implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "邮箱服务器id")
    private Integer mailServerId;

    @ApiModelProperty(value = "邮箱类型")
    private String mailServerType;

    @ApiModelProperty(value = "逻辑删除键")
    @TableLogic
    private Boolean isDelete;


}
