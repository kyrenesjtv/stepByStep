package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huojianxiong
 * @Description RequestInfo
 * @Date 2022/2/27 23:11
 */
@Data
public class RequestInfo implements Serializable {
    private static final long serialVersionUID = -8414797702261191172L;
    //请求路径
    private String apiName;
    //相应时间
    private double responseTime;
    //总耗时
    private long timestamp;
}
