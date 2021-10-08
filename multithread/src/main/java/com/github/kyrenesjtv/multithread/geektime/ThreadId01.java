package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 多线程生成唯一ID
 *
 * @author huojianxiong
 * 2021/10/3 0:31
 */
public class ThreadId01 {

    static final AtomicLong nextId = new AtomicLong(0);

    //定义ThreadLocal变量
    static final ThreadLocal<Long> tl = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    //此方法会为每个线程分配一个唯一的Id
    static long get(){
        return tl.get();
    }



     static class ThreadId extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+":"+ThreadId01.get());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadId threadId = new ThreadId();
            threadId.start();
        }
    }

}
