package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.state.demo3;

import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.state.demo1.State;

/**
 * @author huojianxiong
 * @Description IMario
 * @Date 2022/4/3 16:26
 */
public interface IMario {
    State getName();

    void obtainMushRoom();

    void obtainCape();

    void obtainFireFlower();

    void meetMonster();
}
