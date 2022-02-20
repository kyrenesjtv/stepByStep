package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.ocp;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huojianxiong
 * @Description AlertRule
 * @Date 2022/2/20 16:22
 */
public class AlertRule {
    private static final ConcurrentHashMap<String, Rule> API_RULE_MAP = new ConcurrentHashMap<>();

    public Rule getMatchedRule(String api) {
        return API_RULE_MAP.computeIfAbsent(api, k -> new Rule());
    }

    @Data
    static class Rule {
        private long maxTps;
        private long maxErrorCount;
    }
}
