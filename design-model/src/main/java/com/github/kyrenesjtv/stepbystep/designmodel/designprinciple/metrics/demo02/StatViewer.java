package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo02;

import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestStat;

import java.util.Map;

/**
 * @author huojianxiong
 * @Description StatViewer - 展示接口
 * @Date 2022/3/4 23:39
 */
public interface StatViewer {
    /**
     * @param
     * @param requestStats
     * @param startTimeInMillis
     * @param endTimeInMills
     * @return void
     * @author huojianxiong
     * @description 将数据显示
     * @data 23:41 2022/3/4
     **/
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}
