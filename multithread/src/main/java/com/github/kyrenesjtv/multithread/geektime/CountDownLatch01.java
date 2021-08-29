package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个线程等待一组线程
 *
 * @author huojianxiong
 * 2021/8/29 17:21
 */
public class CountDownLatch01 {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        System.out.println("主线程开始执行==============");
        ExecutorService service01 = Executors.newSingleThreadExecutor();
        service01.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程：" + Thread.currentThread().getName() + "开始执行");
                latch.countDown();
            }
        });
        service01.shutdown();


        ExecutorService service02 = Executors.newSingleThreadExecutor();
        service02.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程：" + Thread.currentThread().getName() + "开始执行");
                latch.countDown();
            }
        });
        service02.shutdown();

        try {
            //等待两个线程执行完毕
            latch.await();
            System.out.println("两个线程执行完毕========");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("========开始执行主线程");

    }

}

