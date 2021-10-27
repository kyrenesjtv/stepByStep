package com.github.kyrenesjtv.eventbus.eventbus.domain;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/10/12 10:38
 */
public class Event {

    private String message;

    public Event(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
