package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo02;

import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.MetricsStorage;
import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestInfo;
import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestStat;

import java.util.*;

/**
 * @author huojianxiong
 * @Description EmailReporter
 * @Date 2022/3/4 23:51
 */
public class EmailReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.add(Calendar.HOUR_OF_DAY, 0);
        calendar.add(Calendar.MINUTE, 0);
        calendar.add(Calendar.SECOND, 0);
        calendar.add(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> aggregate = aggregator.aggregate(requestInfos, durationInMillis);
                viewer.output(aggregate, startTimeInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }

}
