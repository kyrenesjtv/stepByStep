package com.github.kyrenesjtv.stepbystep.designmodel.oo.abs;

import java.util.logging.Level;

/**
 * @author huojianxiong
 * @Description MessageQueueLogger
 * @Date 2022/2/14 18:45
 */
public class MessageQueueLogger extends Logger {

    private MessageQueueClient msgQueueClient;

    public MessageQueueLogger(String name, boolean enabled, Level minPermittedLevel, MessageQueueClient msgQueueClient) {
        super(name, enabled, minPermittedLevel);
        this.msgQueueClient = msgQueueClient;
    }

    @Override
    protected void doLog(Level level, String message) {
        // 格式化level和message,输出到消息中间件
        // msgQueueClient.send(...);
    }
}
