package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo02;

import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.EmailSender;
import com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.metrics.demo01.RequestStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author huojianxiong
 * @Description EmailViewer - 邮件输出统计结果
 * @Date 2022/3/4 23:44
 */
public class EmailViewer implements StatViewer {
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender(/*省略参数*/);
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        //todo 格式化成html 循环toAddresses发送邮箱
        for (String toAddress : toAddresses) {

        }
    }
}
