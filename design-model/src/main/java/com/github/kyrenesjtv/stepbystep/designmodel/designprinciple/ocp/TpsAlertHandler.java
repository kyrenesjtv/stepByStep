package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.ocp;

/**
 * @author huojianxiong
 * @Description TpsAlertHandler - tps到达一定程度发送消息
 * @Date 2022/2/20 16:23
 */
public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
