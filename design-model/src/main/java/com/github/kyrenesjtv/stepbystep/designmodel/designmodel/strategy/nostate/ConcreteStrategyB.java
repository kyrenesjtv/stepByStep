package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.strategy.nostate;

/**
 * @author huojianxiong
 * @Description ConcreteStrategyA
 * @Date 2022/3/27 10:51
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("ConcreteStrategyB-algorithmInterface");
    }
}
