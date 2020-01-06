package com.niu.analysis.mail.domain.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @program: analysis-sequence
 * @description:
 * @author: zhengzz
 * @create: 2019-12-31 12:15
 **
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
@Builder
public class BaseResponse<T extends  Object> {
    @ApiModelProperty("响应码")
    private int code ;
    @ApiModelProperty("响应信息")
    private  String msg;
    @ApiModelProperty("响应结果")
    private T result;

    public BaseResponse(T result) {
        this.result = result;
    }

    public BaseResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public BaseResponse setMsg(String msg) {
        this.msg = msg;
        return  this;
    }

    public  BaseResponse setResult(T result) {
        this.result = result;
        return this;
    }
}
