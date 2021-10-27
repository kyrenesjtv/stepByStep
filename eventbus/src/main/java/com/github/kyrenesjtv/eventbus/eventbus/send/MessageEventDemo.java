package com.github.kyrenesjtv.eventbus.eventbus.send;

import com.github.kyrenesjtv.eventbus.eventbus.domain.EventA;
import com.github.kyrenesjtv.eventbus.eventbus.domain.EventB;
import com.github.kyrenesjtv.eventbus.eventbus.listener.MultipleEventListener;
import com.google.common.eventbus.EventBus;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/10/12 10:40
 */
public class MessageEventDemo {


    public static void main(String[] args) {
        /*
        EventBus eventBus = new EventBus("test");
        //注册监听到eventBus
        eventBus.register(new EventListener());
        //通过eventBus发送两笔消息
        eventBus.post(new Event("send message1"));
        eventBus.post(new Event("send message2"));
        */



        EventBus eventBus = new EventBus("testMultiple");
        //注册监听
        eventBus.register(new MultipleEventListener());
        //发送不同类型的事件
        eventBus.post(new EventA("EventA Message"));
        eventBus.post(new EventB("EventB Message"));
    }


}
