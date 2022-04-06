package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huojianxiong
 * @Description Demo
 * @Date 2022/4/5 23:18
 */
public class Demo {
    private static final int MAX_HANDLED_REQ_COUNT_PER_LOOP = 100;
    private static Queue<Command> queue = new LinkedList<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 100; i++) {
                //工厂模式拿到Command
                queue.add(new GotDiamondCommand(i));
            }

            int handledCount = 0;
            while (handledCount < MAX_HANDLED_REQ_COUNT_PER_LOOP) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.poll().execute();
            }
        }
    }
}
