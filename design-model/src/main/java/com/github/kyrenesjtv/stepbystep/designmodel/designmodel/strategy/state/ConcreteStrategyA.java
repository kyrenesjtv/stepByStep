package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.strategy.state;

/**
 * @author huojianxiong
 * @Description ConcreteStrategyA
 * @Date 2022/3/27 10:51
 */
public class ConcreteStrategyA implements Strategy {

    private String name;

    public ConcreteStrategyA(String name) {
        this.name = name;
    }

    @Override
    public void algorithmInterface() {
        System.out.println("ConcreteStrategyA-algorithmInterface-" + name);
    }
}
