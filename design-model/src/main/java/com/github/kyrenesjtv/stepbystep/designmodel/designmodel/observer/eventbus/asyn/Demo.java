package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.asyn;

import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.syn.entity.EventBO1;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.syn.listener.ListenerA;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.syn.listener.ListenerB;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * @author huojianxiong
 * @Description Demo
 * @Date 2022/3/23 17:47
 */
public class Demo {

    public static void main(String[] args) {
        EventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(8));// 异步阻塞模式
        eventBus.register(new ListenerA());
        eventBus.register(new ListenerB());
        eventBus.post(new EventBO1(1, "123"));
    }

}
