package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.state.demo1;

import lombok.Getter;

/**
 * @author huojianxiong
 * @Description State
 * @Date 2022/4/2 10:45
 */
@Getter
public enum State {

    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);
    
    private int value;

    private State(int value) {
        this.value = value;
    }
}
