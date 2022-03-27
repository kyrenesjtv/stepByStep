package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.strategy.nostate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huojianxiong
 * @Description StrategyFactory
 * @Date 2022/3/27 10:52
 */
public class StrategyFactory {
    private static final Map<String, Strategy> strategies = new HashMap<>();

    /*
     * @author huojianxiong
     * @description  无状态的实现才能这么弄，如果需要根据参数来返回对应的实现的话，就必须要if else去做了。
     * @data  10:59 2022/3/27
     * @param
     * @param null
     * @return
     **/
    static {
        strategies.put("A", new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategies.get(type);
    }
}
