package com.github.kyrenesjtv.eventbus.eventbus.listener;

import com.github.kyrenesjtv.eventbus.eventbus.domain.EventA;
import com.github.kyrenesjtv.eventbus.eventbus.domain.EventB;
import com.google.common.eventbus.Subscribe;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/10/12 10:44
 */
public class MultipleEventListener {

    @Subscribe
    public void listenerEventA(EventA eventA){
        System.out.println("subscribe EventA:" + eventA.getMessage());
    }

    @Subscribe
    public void listenerEventB(EventB eventB){
        System.out.println("subscribe EventB:" + eventB.getMessage());
    }

}
