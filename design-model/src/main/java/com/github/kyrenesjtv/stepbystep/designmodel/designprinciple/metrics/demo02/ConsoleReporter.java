package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo02;

import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.MetricsStorage;
import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestInfo;
import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestStat;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huojianxiong
 * @Description ConsoleReporter - 获取控制台展示所需要的数据
 * @Date 2022/3/4 23:48
 */
public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
        this.executor = new ScheduledThreadPoolExecutor(1);
    }

    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(() -> {
            long durationInMillis = durationInSeconds * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;
            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
            Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
            viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
        }, 0L, periodInSeconds, TimeUnit.SECONDS);
    }

}
