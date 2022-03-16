package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.bridge;

/**
 * @author huojianxiong
 * @Description SevereNotification
 * @Date 2022/3/16 16:22
 */
public class UrgencyNotification extends Notification {

    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
