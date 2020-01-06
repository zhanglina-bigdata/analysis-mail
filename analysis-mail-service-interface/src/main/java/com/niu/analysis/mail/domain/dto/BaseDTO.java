package com.niu.analysis.mail.domain.dto;

import lombok.*;

/**
 * @program: analysis-mail
 * @description:
 * @author: zhengzz
 * @create: 2020-01-06 12:04
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseDTO<T> {
    private T result;

    public BaseDTO setResult(T result) {
        this.result = result;
        return this;
    }
}
