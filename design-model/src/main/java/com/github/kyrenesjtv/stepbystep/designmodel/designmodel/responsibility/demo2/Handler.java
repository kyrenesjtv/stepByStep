package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.responsibility.demo2;

/**
 * @author huojianxiong
 * @Description Handler
 * @Date 2022/3/31 10:27
 */
public abstract class Handler {

    protected Handler successor = null;

    public final void handler() {
        boolean handled = doHandle();
        if (successor != null && !handled) {
            successor.handler();
        }
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected abstract boolean doHandle();

}
