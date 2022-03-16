package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.bridge;

/**
 * @author huojianxiong
 * @Description Notification
 * @Date 2022/3/16 16:21
 */
public abstract class Notification {

    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);
}
