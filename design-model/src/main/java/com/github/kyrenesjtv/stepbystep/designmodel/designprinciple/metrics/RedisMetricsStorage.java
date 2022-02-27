package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics;

import java.util.List;
import java.util.Map;

/**
 * @author huojianxiong
 * @Description RedisMetricsStorage
 * @Date 2022/2/27 23:17
 */
public class RedisMetricsStorage implements MetricsStorage {
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
