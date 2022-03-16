package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.bridge;

import java.util.List;

/**
 * @author huojianxiong
 * @Description TelephoneMsgSender
 * @Date 2022/3/16 16:20
 */
public class EmailMsgSender implements MsgSender {

    private List<String> emails;

    public EmailMsgSender(List emails) {
        this.emails = emails;
    }

    @Override
    public void send(String message) {
        System.out.println("发邮件");
    }
}
