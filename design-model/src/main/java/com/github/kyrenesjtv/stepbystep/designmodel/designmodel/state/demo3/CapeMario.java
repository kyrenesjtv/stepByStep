package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.state.demo3;

import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.state.demo1.State;

/**
 * @author huojianxiong
 * @Description CapeMario
 * @Date 2022/4/3 16:30
 */
public class CapeMario implements IMario {

    private MarioStateMachine stateMachine;

    public CapeMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void obtainMushRoom() {

    }

    @Override
    public void obtainCape() {

    }

    @Override
    public void obtainFireFlower() {

    }

    @Override
    public void meetMonster() {
        stateMachine.setCurrentState(new SmallMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() - 200);
    }
}
