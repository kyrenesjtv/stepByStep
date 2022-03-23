package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.syn;

import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.syn.entity.EventBO1;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.syn.listener.ListenerA;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.syn.listener.ListenerB;
import com.google.common.eventbus.EventBus;

/**
 * @author huojianxiong
 * @Description Demo
 * @Date 2022/3/23 17:25
 */
public class Demo {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus("syn");
        eventBus.register(new ListenerA());
        eventBus.register(new ListenerB());
        eventBus.post(new EventBO1(1, "123"));
    }
}
