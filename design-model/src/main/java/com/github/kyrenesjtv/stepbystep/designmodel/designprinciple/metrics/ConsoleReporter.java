package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huojianxiong
 * @Description ConsoleRepoter - 控制台输出统计信息
 * @Date 2022/3/3 09:55
 */
public class ConsoleReporter {

    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executorService;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executorService = new ScheduledThreadPoolExecutor(1);
    }

    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executorService.scheduleAtFixedRate(() -> {
            long durationInMillis = durationInSeconds * 1000;//间隔时间
            long endTimeInMillis = System.currentTimeMillis();//结束时间
            long startTimeInMillis = endTimeInMillis - durationInMillis;//开始时间
            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
            Map<String, RequestStat> stats = new HashMap<>();
            requestInfos.forEach((k, v) -> {
                RequestStat aggregate = Aggregator.aggregate(v, durationInMillis);
                stats.put(k, aggregate);
            });
            System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
            System.out.println(JSONObject.toJSONString(stats));
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}
