package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.responsibility.demo3;

/**
 * @author huojianxiong
 * @Description HandlerA
 * @Date 2022/3/31 11:05
 */
public class HandlerB implements IHandler {
    @Override
    public boolean handle() {
        boolean handled = false;
        System.out.println("HandlerB-handle");
        return handled;
    }
}
