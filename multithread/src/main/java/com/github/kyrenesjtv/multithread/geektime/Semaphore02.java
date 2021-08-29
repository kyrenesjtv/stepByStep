package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.Semaphore;

/**
 * 限流器 - 多个线程访问临界区（并发的代码块）
 *
 * @author huojianxiong
 * 2021/8/29 15:32
 */
public class Semaphore02 {

    //初始化信号量
    static int count;
    static final Semaphore s = new Semaphore(1);

    //用信号量保证互斥
    static void addOne() throws InterruptedException {
        s.acquire();
        try {
            count++;
        } finally {
            s.release();
        }
    }

}
