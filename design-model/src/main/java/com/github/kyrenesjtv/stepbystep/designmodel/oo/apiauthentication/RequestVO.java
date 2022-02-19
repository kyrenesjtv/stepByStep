package com.github.kyrenesjtv.stepbystep.designmodel.oo.apiauthentication;

import lombok.Data;

/**
 * @author huojianxiong
 * @Description RequestVO
 * @Date 2022/2/20 00:05
 */
@Data
public class RequestVO<T> {
    private String token;
    private long timestamp;
    private String appId;
    private T data;
}
