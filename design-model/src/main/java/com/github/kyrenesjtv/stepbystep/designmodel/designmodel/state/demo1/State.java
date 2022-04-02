package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.state.demo1;

import lombok.Getter;

/**
 * @author huojianxiong
 * @Description State
 * @Date 2022/4/2 10:45
 */
@Getter
public enum State {

    SMALL(0),//普通
    SUPER(1),//吃了变大的蘑菇
    FIRE(2),//获得火焰
    CAPE(3);//获得斗篷

    private int value;

    private State(int value) {
        this.value = value;
    }
}
