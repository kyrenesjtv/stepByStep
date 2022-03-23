package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.syn.listener;

import com.alibaba.fastjson.JSON;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.syn.entity.EventBO1;
import com.google.common.eventbus.Subscribe;

/**
 * @author huojianxiong
 * @Description ListenerA
 * @Date 2022/3/23 17:23
 */
public class ListenerA {

    @Subscribe
    public void doSomethingA(EventBO1 eventBO1) {
        System.out.println("doSomethingA" + JSON.toJSON(eventBO1));
    }
}
