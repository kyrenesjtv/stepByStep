package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * google的高性能限流器
 *
 * @author huojianxiong
 * 2021/10/31 16:34
 */
public class RateLimiter01 {

    public static void main(String[] args) {
        //限流器，1S2个请求
//        RateLimiter rateLimiter = RateLimiter.create(3);
        SimpleLimiter02 simpleLimiter02 = new SimpleLimiter02();
        //执行任务的线程池
        ExecutorService es = Executors.newFixedThreadPool(1);
        //记录上一次的执行时间
        final long[] preTime = {System.nanoTime()};
        //测试执行20次
        for (int i = 0; i < 20; i++) {
            //限流器限流
            simpleLimiter02.acquire();
            //异步提交任务
            es.execute(()->{
                long currTime = System.nanoTime();
                //打印时间间隔：毫秒
                System.out.println( (currTime- preTime[0])/1000_000);
                preTime[0] = currTime;
            });
        }
        


    }

}
