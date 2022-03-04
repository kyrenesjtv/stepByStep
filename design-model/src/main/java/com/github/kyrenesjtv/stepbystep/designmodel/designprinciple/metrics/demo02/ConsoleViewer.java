package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo02;

import com.alibaba.fastjson.JSON;
import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestStat;

import java.util.Map;

/**
 * @author huojianxiong
 * @Description ConsoleViewer - 控制台输出统计结果
 * @Date 2022/3/4 23:42
 */
public class ConsoleViewer implements StatViewer {

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        System.out.println(JSON.toJSONString(requestStats));
    }
}
