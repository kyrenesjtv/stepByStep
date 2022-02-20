package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.ocp;

/**
 * @author huojianxiong
 * @Description ErrorAlertHandler - 请求错误数到达一定程度发送消息
 * @Date 2022/2/20 16:27
 */

public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
