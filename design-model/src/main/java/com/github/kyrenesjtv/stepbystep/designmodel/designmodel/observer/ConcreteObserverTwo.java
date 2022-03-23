package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer;

import org.springframework.stereotype.Service;

/**
 * @author huojianxiong
 * @Description ConcreteObserverOne
 * @Date 2022/3/23 16:03
 */
@Service
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo-update-" + message.getMsg());
    }
}
