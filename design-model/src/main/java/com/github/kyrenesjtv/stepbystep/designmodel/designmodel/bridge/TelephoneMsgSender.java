package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.bridge;

import java.util.List;

/**
 * @author huojianxiong
 * @Description TelephoneMsgSender
 * @Date 2022/3/16 16:20
 */
public class TelephoneMsgSender implements MsgSender {

    private List<String> telephones;

    public TelephoneMsgSender(List telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        System.out.println("打电话");
    }
}
