package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.responsibility.demo2;

/**
 * @author huojianxiong
 * @Description HandlerA
 * @Date 2022/3/31 10:28
 */
public class HandlerA extends Handler {
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        System.out.println("HandlerA-doHandle");
        return handled;
    }
}
