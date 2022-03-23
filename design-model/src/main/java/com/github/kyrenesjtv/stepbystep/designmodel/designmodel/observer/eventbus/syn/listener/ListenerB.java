package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.syn.listener;

import com.alibaba.fastjson.JSON;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer.eventbus.syn.entity.EventBO1;
import com.google.common.eventbus.Subscribe;

/**
 * @author huojianxiong
 * @Description ListenerB
 * @Date 2022/3/23 17:23
 */
public class ListenerB {

    @Subscribe
    public void doSomethingB(EventBO1 eventBO1) {
        System.out.println("doSomethingB" + JSON.toJSON(eventBO1));
    }

}
