package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.responsibility.demo1;

/**
 * @author huojianxiong
 * @Description HandlerA
 * @Date 2022/3/31 10:28
 */
public class HandlerA extends Handler {
    @Override
    public void handle() {
        System.out.println("HandlerA-handle");
        boolean handled = false;
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
