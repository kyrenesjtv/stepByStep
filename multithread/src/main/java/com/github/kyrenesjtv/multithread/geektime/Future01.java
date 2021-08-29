package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * future 实现了callable。 支持返回参数
 *
 * @author huojianxiong
 * 2021/8/29 21:33
 */
public class Future01 {


    static class T1Task implements Callable<String> {

        FutureTask<String> ft2;

        //ti任务需要t2任务的futureTask
        T1Task(FutureTask<String> ft2) {
            this.ft2 = ft2;
        }

        @Override
        public String call() throws Exception {

            System.out.println("T1：洗水壶。。。。");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("T1:烧开水");
            TimeUnit.SECONDS.sleep(15);

            //获取t2的茶叶
            String s = ft2.get();
            System.out.println("T1:拿到茶叶:" + s);

            System.out.println("T1：泡茶");

            return "上茶:" + s;
        }
    }

    static class T2Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("T2：洗查壶。。。。");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("T2：洗茶杯。。。。");
            TimeUnit.SECONDS.sleep(2);

            System.out.println("T2：拿茶叶。。。。");
            TimeUnit.SECONDS.sleep(1);

            return "龙井";

        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ft2 = new FutureTask<>(new T2Task());
        FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));

        Thread thread1 = new Thread(ft1);
        thread1.start();
        Thread thread2 = new Thread(ft2);
        thread2.start();

        System.out.println(ft1.get());

    }


}
