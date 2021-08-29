package com.github.kyrenesjtv.multithread.video;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/8/29 16:15
 */
public class addOne {

    private static long value = 0;

    private synchronized void add10K() {
        for (int i = 0; i < 10000; i++) {
            value = value + 1;
        }
    }

    public static long calc() throws InterruptedException {
        addOne addOne = new addOne();
        Thread t1 = new Thread(() -> {
            addOne.add10K();
        });
        Thread t2 = new Thread(() -> {
            addOne.add10K();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return value;
    }


    public static void main(String[] args) throws InterruptedException {
        long calc = calc();
        System.out.println(calc);
    }
}
