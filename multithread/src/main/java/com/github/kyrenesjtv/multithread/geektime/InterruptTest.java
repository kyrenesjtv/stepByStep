package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/10/4 22:12
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        /*
        System.out.println("111111");
        System.out.println(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        if(Thread.currentThread().isInterrupted()){
            return;
        }
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println("22222");
        */

        BlockingQueue<String> bq = new LinkedBlockingQueue<>();
        bq.put("111");
        bq.put("222");
        bq.put("333");
        System.out.println(bq.take());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
    }

}
