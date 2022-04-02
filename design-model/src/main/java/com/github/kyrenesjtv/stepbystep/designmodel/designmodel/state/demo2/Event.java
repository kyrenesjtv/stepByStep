package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.state.demo2;

import lombok.Getter;

/**
 * @author huojianxiong
 * @Description Event
 * @Date 2022/4/2 13:38
 */
@Getter
public enum Event {
    GOT_MUSHROOM(0), GOT_CAPE(1), GOT_FIRE(2), MET_MONSTER(3);
    private int value;

    private Event(int value) {
        this.value = value;
    }

}
