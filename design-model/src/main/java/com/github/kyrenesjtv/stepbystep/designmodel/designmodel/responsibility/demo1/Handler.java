package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.responsibility.demo1;

/**
 * @author huojianxiong
 * @Description Handler
 * @Date 2022/3/31 10:27
 */
public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handle();

}
