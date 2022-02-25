package com.github.kyrenesjtv.stepbystep.java4error100.code.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author huojianxiong
 * @Description 不推荐使用Executors ，手动 new ThreadPoolExecutor
 * @Date 2022/2/22 17:44
 */
@RequestMapping("/threadpool")
@RestController
@Slf4j
public class ExecutorsDemo {

    @GetMapping("/oom1")
    public void oom1() {
//        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //打印线程池的信息
        printStats(threadPoolExecutor);
        for (int i = 0; i < 10000000; i++) {
            threadPoolExecutor.execute(() -> {
                String payload = IntStream.range(1, 10000).mapToObj(__ -> "a")
                        .collect(Collectors.joining("")) + UUID.randomUUID();
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                }
                log.info(payload);
            });
        }
    }

    @GetMapping("/right")
    public Integer right() throws InterruptedException {
        //使用一个计数器跟踪完成的任务书
        AtomicInteger atomicInteger = new AtomicInteger();
        //创建一个具有2个核心线程数，5个最大线程数，使用量为10的ArrayBlockingQueue阻塞队列作为作队列的线程池，使用默认的AbortPolicy拒绝策略

        /*
        不会初始化 corePoolSize 个线程，有任务来了才创建工作线程；
        当核心线程满了之后不会立即扩容线程池，而是把任务堆积到工作队列中；
        当工作队列满了后扩容线程池，一直到线程个数达到 maximumPoolSize 为止；
        如果队列已满且达到了最大线程后还有任务进来，按照拒绝策略处理；
        当线程数大于核心线程数时，线程等待 keepAliveTime 后还是没有任务需要处理的话，收缩线程到核心线程数。


         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,//核心线程数
                5,//最大线程数
                5,//存活时间
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(10),//工作队列
                new ThreadFactoryBuilder().setNameFormat("demo-tread-pool-%d").build(),//线程名字
                new ThreadPoolExecutor.AbortPolicy()//拒绝策略
        );
        printStats(threadPoolExecutor);
        //每隔1s提交一次，一共提交20个任务
        IntStream.rangeClosed(1, 20).forEach(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.info("睡眠报错：", e);
            }
            int id = atomicInteger.incrementAndGet();
            try {
                threadPoolExecutor.submit(() -> {
                    log.info("{} started", id);
                    //每个任务耗时10秒
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    log.info("{} finished", id);
                });
            } catch (Exception e) {
                //提交出现异常的话，打印出错信息并为计数器减一
                log.error("error submitting task {}", id, e);
                atomicInteger.decrementAndGet();
            }

        });
        TimeUnit.SECONDS.sleep(60);
        return atomicInteger.intValue();
    }

    private void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("=========================");
            log.info("Pool Size: {}", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
            log.info("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }
}
