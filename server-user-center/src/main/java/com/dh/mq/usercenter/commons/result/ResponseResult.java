package com.dh.mq.usercenter.commons.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseResult<T> extends BaseResult {
    private  Integer code;
    private String msg;
    private T data;
}
