package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01;

import lombok.Builder;
import lombok.Data;

/**
 * @author huojianxiong
 * @Description RequestStat - 统计实体类
 * @Date 2022/2/27 23:29
 */
@Data
@Builder
public class RequestStat {
    //最大相应时间
    private double maxResponseTime;
    //最小相应时间
    private double minResponseTime;
    //平均相应时间
    private double avgResponseTime;
    //第99.9%的相应时间
    private double p999ResponseTime;
    //第99%的相应时间
    private double p99ResponseTime;
    //总数
    private long count;
    private long tps;

}
