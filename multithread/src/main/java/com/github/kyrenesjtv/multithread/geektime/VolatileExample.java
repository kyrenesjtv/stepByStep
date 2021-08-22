package com.github.kyrenesjtv.multithread.geektime;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/8/16 11:06
 */
public class VolatileExample {
    int x = 0;
    volatile boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            System.out.println("变量X === ： " + x);
        }
    }

    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();
        Thread thread1 = new Thread(() -> {
            volatileExample.writer();
        });

        Thread thread2 = new Thread(() -> {
            volatileExample.reader();
        });

        thread1.start();
        thread2.start();
    }


}

