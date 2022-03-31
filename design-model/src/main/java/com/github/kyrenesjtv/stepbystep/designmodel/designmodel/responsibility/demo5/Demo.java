package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.responsibility.demo5;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huojianxiong
 * @Description Demo
 * @Date 2022/3/31 11:06
 */
public class Demo {

    @Autowired
    private static HandlerChain handlerChain;

    public static void main(String[] args) {
        handlerChain.handle();
        handlerChain.handle();
    }
}
