package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo02;

import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.MetricsStorage;
import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestInfo;
import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestStat;

import java.util.List;
import java.util.Map;

/**
 * @author huojianxiong
 * @Description ScheduledReporter
 * @Date 2022/3/5 00:04
 */
public abstract class ScheduledReporter {
    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatViewer statViewer;

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer statViewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.statViewer = statViewer;
    }

    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
        statViewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }

}
