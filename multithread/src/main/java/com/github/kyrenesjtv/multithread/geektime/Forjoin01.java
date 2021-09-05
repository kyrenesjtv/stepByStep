package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 将任务分解，然后结果合并。如果需要没有返回结果的，可以使用RecursiveAction
 *
 * @author huojianxiong
 * 2021/9/5 14:48
 */
public class Forjoin01 {

    public static void main(String[] args) {
        //创建分治任务线程池
        ForkJoinPool fjp = new ForkJoinPool(3);
        //创建分治任务
        Fibonacci fib = new Fibonacci(30);
        //启动分治任务
        Integer invoke = fjp.invoke(fib);

        System.out.println(invoke);
    }

    static class Fibonacci extends RecursiveTask<Integer> {
        private static final long serialVersionUID = 1508934486715621768L;
        final int n;

        Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }
            Fibonacci f1 = new Fibonacci(n - 1);
            //return merge(mr2.compute(), mr1.join()); // ①原始代码
            //return merge(mr1.join(), mr2.compute()); // ②能正常执行
            //return merge(mr2.join(), mr1.compute()); // ③会阻塞
            //compute(),应该是自动fork了，然后让线程保持在计算的状态

            /**
             * 写法1
             //创建子任务
             f1.fork();
             Fibonacci f2 = new Fibonacci(n - 2);
             //等待子任务结果，合并结果
             return f2.compute() + f1.join();
             */
            Fibonacci f2 = new Fibonacci(n - 2);
            f1.fork();
            f2.fork();
            Integer join1 = f1.join();
            Integer join2 = f2.join();
            return join1 + join2;
        }
    }
}
