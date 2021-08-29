package com.github.kyrenesjtv.multithread.geektime;

import java.util.Queue;

/**
 * 信号量
 *
 * @author huojianxiong
 * 2021/8/29 15:28
 */
public class Semaphore01 {
    //计数器
    int count;
    //等待队列，存放线程
    Queue queue;

    Semaphore01(int c) {
        this.count = c;
    }

    void down() {
        this.count--;
        if (this.count < 0) {
            //将当前线程插入到等待队列
            //阻塞当前队列
        }
    }

    void up() {
        this.count++;
        if (this.count <= 0) {
            //移除等待队列中的某个线程T
            //唤醒线程T
        }
    }

}
