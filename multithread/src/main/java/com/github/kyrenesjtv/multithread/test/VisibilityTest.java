package com.github.kyrenesjtv.multithread.test;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/8/16 10:57
 */
public class VisibilityTest {
    private static long count = 0;

    private void add10k() {
        int idx = 0;
        for (int i = 0; i < 10000; i++) {
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        VisibilityTest visibilityTest = new VisibilityTest();
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
