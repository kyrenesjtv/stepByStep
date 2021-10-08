package com.github.kyrenesjtv.multithread.geektime;

import javafx.concurrent.Task;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/10/4 22:25
 */
public class ConsumerProducer {

    BlockingQueue<Task> bq = new LinkedBlockingQueue<>(2000);

    //启动5个消费者，批量执行任务
    void start(){
        ExecutorService es= Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.execute(()->{
                try {
                    while (true){
                        //获取批量任务
                        List<Task> ts = poolTask(); 
                    }
                }catch (Exception e){

                }
                });
        }
    }

    private List<Task> poolTask() throws InterruptedException {
        List<Task> ts = new LinkedList<>();
        //阻塞的获取一条任务
        Task take = bq.take();
        while (take != null){
            ts.add(take);
            //非阻塞的获取一条任务
            take = bq.poll();
        }
        return ts;
    }

}
