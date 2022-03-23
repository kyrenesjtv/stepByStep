package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.observer;


/**
 * @author huojianxiong
 * @Description Subject
 * @Date 2022/3/23 16:00
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Message message);

}
