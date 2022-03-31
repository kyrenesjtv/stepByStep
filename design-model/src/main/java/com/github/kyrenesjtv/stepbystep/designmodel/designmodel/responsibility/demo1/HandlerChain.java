package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.responsibility.demo1;

/**
 * @author huojianxiong
 * @Description HandlerChain
 * @Date 2022/3/31 10:29
 */
public class HandlerChain {
    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}
