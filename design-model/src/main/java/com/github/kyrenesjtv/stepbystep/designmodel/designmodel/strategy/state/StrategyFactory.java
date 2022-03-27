package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.strategy.state;

/**
 * @author huojianxiong
 * @Description StrategyFactory
 * @Date 2022/3/27 10:52
 */
public class StrategyFactory {

    /**
     * @param
     * @param type
     * @param name
     * @return
     * @author huojianxiong
     * @description 有状态的实现，就必须要用if else。因为参数是动态的，每次生成的东西是不一样的
     * @data 11:14 2022/3/27
     **/
    public static Strategy getStrategy(String type, String name) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        if (type.equals("A")) {
            return new ConcreteStrategyA(name);
        } else if (type.equals("B")) {
            return new ConcreteStrategyB(name);
        } else {
            return null;
        }

    }
}
