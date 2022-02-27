package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author huojianxiong
 * @Description Aggregator - 聚合帮助类
 * @Date 2022/2/27 23:28
 */
public class Aggregator {

    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;
        for (RequestInfo requestInfo : requestInfos) {
            count++;
            double responseTime = requestInfo.getResponseTime();
            if (maxRespTime < responseTime) {
                maxRespTime = responseTime;
            }
            if (minRespTime > responseTime) {
                minRespTime = responseTime;
            }
            sumRespTime += responseTime;
        }
        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        long tps = count / durationInMillis * 1000;
        Collections.sort(requestInfos, new Comparator<RequestInfo>() {
            @Override
            public int compare(RequestInfo o1, RequestInfo o2) {
                double diffTime = o1.getResponseTime() - o2.getResponseTime();
                if (diffTime < 0.0) {
                    return -1;
                } else if (diffTime > 0.0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int idx999 = (int) (count * 0.999);
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }
        RequestStat requestStat = RequestStat.builder()
                .avgResponseTime(avgRespTime)
                .maxResponseTime(maxRespTime)
                .minResponseTime(minRespTime)
                .p99ResponseTime(p99RespTime)
                .p999ResponseTime(p999RespTime)
                .tps(tps)
                .count(count)
                .build();
        return requestStat;
    }
}
