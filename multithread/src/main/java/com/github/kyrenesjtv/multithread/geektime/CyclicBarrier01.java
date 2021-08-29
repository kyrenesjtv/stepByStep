package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.CyclicBarrier;

/**
 * 一组线程之间相互等待
 *
 * @author huojianxiong
 * 2021/8/29 17:27
 */
public class CyclicBarrier01 {

    static class TaskThread extends Thread {

        CyclicBarrier barrier;

        public TaskThread(CyclicBarrier cyclicBarrier) {
            barrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " 到达删栏 A");
                //等待所有线程到这里
                barrier.await();
                System.out.println(getName() + " 冲破删栏 A");

                Thread.sleep(2000);
                System.out.println(getName() + " 到达删栏 A");
                //等待所有线程到这里
                barrier.await();
                System.out.println(getName() + " 冲破删栏 A");


            } catch (Exception e) {

            }

        }
    }


    public static void main(String[] args) {
        int threadNum = 5;
        //public CyclicBarrier(int parties)
        //public CyclicBarrier(int parties, Runnable barrierAction)
        //        parties 是参与线程的个数
        //        第二个构造方法有一个 Runnable 参数，这个参数的意思是最后一个到达线程要做的任务
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "最后完成任务");
            }
        });

        for (int i = 0; i < threadNum; i++) {
            new TaskThread(cyclicBarrier).start();
        }

    }


}
