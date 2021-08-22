package com.github.kyrenesjtv.multithread.test;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/8/16 10:57
 */
public class VisibilitySynTest {
    private static long count = 0;

    //添加synchronized 具有原子性
    private synchronized void add10k() {
        int idx = 0;
        for (int i = 0; i < 10000; i++) {
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        VisibilitySynTest visibilityTest = new VisibilitySynTest();
        Thread th1 = new Thread(() -> {
            visibilityTest.add10k();
        });
        Thread th2 = new Thread(() -> {
            visibilityTest.add10k();
        });
        th1.start();
        th2.start();

        //等待2个线程执行完
        th1.join();
        th2.join();
        return count;
    }

    public static void main(String[] args) {
        try {
            long calc = calc();
            System.out.println(calc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
