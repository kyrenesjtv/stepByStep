package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01;

import java.util.List;
import java.util.Map;

/**
 * @author huojianxiong
 * @Description MetricsStorage - 数据存储
 * @Date 2022/2/27 23:10
 */
public interface MetricsStorage {
    /**
     * @param
     * @param requestInfo
     * @return void
     * @author huojianxiong
     * @description 保存接口的请求信息
     * @data 23:12 2022/2/27
     **/
    void saveRequestInfo(RequestInfo requestInfo);

    /**
     * @param
     * @param apiName
     * @param startTimeInMillis
     * @param endTimeInMillis
     * @return java.util.List<com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestInfo>
     * @author huojianxiong
     * @description 根据apiName和时间返回RequestInfo
     * @data 23:15 2022/2/27
     **/
    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    /**
     * @param
     * @param startTimeInMillis
     * @param endTimeInMillis
     * @return java.util.Map<java.lang.String, java.util.List < com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestInfo>>
     * @author huojianxiong
     * @description 根据时间返回RequestInfo
     * @data 23:16 2022/2/27
     **/
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
