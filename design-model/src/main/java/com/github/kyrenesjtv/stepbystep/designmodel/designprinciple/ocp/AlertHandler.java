package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.ocp;

/**
 * @author huojianxiong
 * @description 规则信息发送抽象类
 * @data 16:39 2022/2/20
 **/
public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}