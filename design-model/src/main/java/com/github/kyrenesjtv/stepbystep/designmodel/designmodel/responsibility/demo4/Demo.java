package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.responsibility.demo4;

/**
 * @author huojianxiong
 * @Description Demo
 * @Date 2022/3/31 11:06
 */
public class Demo {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}
