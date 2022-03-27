package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.strategy.state;

/**
 * @author huojianxiong
 * @Description Demo
 * @Date 2022/3/27 10:57
 */
public class Demo {


    public static void main(String[] args) {
        Strategy strategy = StrategyFactory.getStrategy("A", "nameA");
        strategy.algorithmInterface();

    }
}
