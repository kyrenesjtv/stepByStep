package com.github.kyrenesjtv.multithread.video;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/9/5 16:50
 */
public class Callable01 {


    static class callable01 implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "callable01";
        }
    }


    static class callable02 implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "callable02";
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        callable01 callable01 = new callable01();
        callable02 callable02 = new callable02();
        //
        //        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //        String s01 = executorService.submit(callable01).get();
        //        String s02 = executorService.submit(callable02).get();
        //        System.out.println(s01);
        //        System.out.println(s02);

        //callable无法用new Thread() 来执行，所以需要futureTask。 futureTask实现了futre和callable

        FutureTask<String> task01 = new FutureTask<>(callable01);
        FutureTask<String> task02 = new FutureTask<>(callable02);

        Thread t1 = new Thread(task01);
        t1.start();

        Thread t2 = new Thread(task02);
        t2.start();
        System.out.println(task01.get());
        System.out.println(task02.get());

    }


}
