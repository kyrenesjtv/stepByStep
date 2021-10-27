package com.github.kyrenesjtv.eventbus.eventbus.listener;

import com.github.kyrenesjtv.eventbus.eventbus.domain.Event;
import com.google.common.eventbus.Subscribe;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/10/12 10:39
 */
public class EventListener {

    @Subscribe
    public void listener(Event event){
        System.out.println("Subscribe 接收消息:" + event.getMessage());
    }

}
