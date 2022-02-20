package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.ocp;

import lombok.Data;

@Data
public class ApiStatInfo {
    private String api;
    private long requestCount;
    private long errorCount;
    private long durationOfSeconds;
}