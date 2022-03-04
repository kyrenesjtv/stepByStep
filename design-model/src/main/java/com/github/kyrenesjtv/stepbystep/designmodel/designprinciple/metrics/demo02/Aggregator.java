package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo02;

import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestInfo;
import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestStat;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huojianxiong
 * @Description Aggregator01 - 统计聚合类
 * @Date 2022/3/4 22:53
 */
public class Aggregator {

    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        requestInfos.forEach((k, v) -> {
            RequestStat requestStat = doAggregate(v, durationInMillis);
            requestStats.put(k, requestStat);
        });
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfoList, long durationInMillis) {
        return RequestStat.builder()
                .avgResponseTime(avg(requestInfoList))
                .maxResponseTime(max(requestInfoList))
                .minResponseTime(min(requestInfoList))
                .p99ResponseTime(p99RespTime(requestInfoList))
                .p999ResponseTime(p999RespTime(requestInfoList))
                .tps(tps(requestInfoList, durationInMillis))
                .count(requestInfoList.size())
                .build();
    }

    private long tps(List<RequestInfo> requestInfoList, long durationInMillis) {
        if (CollectionUtils.isEmpty(requestInfoList) && durationInMillis > 0) {
            return BigDecimal.ZERO.longValue();
        }
        return (long) (requestInfoList.stream().mapToDouble(RequestInfo::getResponseTime).sum() / (durationInMillis * 1000));
    }

    private double avg(List<RequestInfo> requestInfoList) {
        if (CollectionUtils.isEmpty(requestInfoList)) {
            return BigDecimal.ZERO.doubleValue();
        }
        return requestInfoList.stream().mapToDouble(RequestInfo::getResponseTime).average().orElse(BigDecimal.ZERO.doubleValue());
    }

    private double min(List<RequestInfo> requestInfoList) {
        if (CollectionUtils.isEmpty(requestInfoList)) {
            return BigDecimal.ZERO.doubleValue();
        }
        return requestInfoList.stream().mapToDouble(RequestInfo::getResponseTime).min().orElse(BigDecimal.ZERO.doubleValue());
    }

    private double max(List<RequestInfo> requestInfoList) {
        if (CollectionUtils.isEmpty(requestInfoList)) {
            return BigDecimal.ZERO.doubleValue();
        }
        return requestInfoList.stream().mapToDouble(RequestInfo::getResponseTime).max().orElse(BigDecimal.ZERO.doubleValue());
    }

    private double p999RespTime(List<RequestInfo> requestInfoList) {
        if (CollectionUtils.isEmpty(requestInfoList)) {
            return BigDecimal.ZERO.doubleValue();
        }
        List<RequestInfo> requestInfosAsc = requestInfoList.stream().sorted(Comparator.comparing(RequestInfo::getResponseTime)).collect(Collectors.toList());
        return requestInfosAsc.get((int) (requestInfoList.size() * 0.999)).getResponseTime();
    }

    private double p99RespTime(List<RequestInfo> requestInfoList) {
        if (CollectionUtils.isEmpty(requestInfoList)) {
            return BigDecimal.ZERO.doubleValue();
        }
        List<RequestInfo> requestInfosAsc = requestInfoList.stream().sorted(Comparator.comparing(RequestInfo::getResponseTime)).collect(Collectors.toList());
        return requestInfosAsc.get((int) (requestInfoList.size() * 0.99)).getResponseTime();
    }


}
