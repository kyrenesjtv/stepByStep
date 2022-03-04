package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01;

import java.util.List;
import java.util.Map;

/**
 * @author huojianxiong
 * @Description MysqlMetricsStorage
 * @Date 2022/2/27 23:18
 */
public class MysqlMetricsStorage implements MetricsStorage {
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
        return null;
    }
}
