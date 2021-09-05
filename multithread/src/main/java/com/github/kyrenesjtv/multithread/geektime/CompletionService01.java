package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.*;

/**
 * 批量异步执行任务
 *
 * @author huojianxiong
 * 2021/9/5 14:26
 */
public class CompletionService01 {

    public static void main(String[] args) throws Exception {

        //这种情况下的话，如果submit1执行时间长，submit2执行时间短，会影响其他的执行效率
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> submit1 = executorService.submit(() -> getSomething());

        Future<Integer> submit2 = executorService.submit(() -> getSomething());

        Future<Integer> submit3 = executorService.submit(() -> getSomething());

        Integer integer1 = submit1.get();
        executorService.execute(() -> save(integer1));

        Integer integer2 = submit2.get();
        executorService.execute(() -> save(integer2));

        Integer integer3 = submit3.get();
        executorService.execute(() -> save(integer3));


        //增加阻塞队列
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        executorService.submit(() -> {
            try {
                queue.put(getSomething());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                queue.put(getSomething());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                queue.put(getSomething());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < 3; i++) {
            Integer take = queue.take();
            executorService.execute(() -> save(take));
        }


        //采用
        ExecutorCompletionService<Integer> cs = new ExecutorCompletionService<>(executorService);

        cs.submit(() -> getSomething());
        cs.submit(() -> getSomething());
        cs.submit(() -> getSomething());

        //将结果保存
        for (int i = 0; i < 3; i++) {
            Integer o = cs.take().get();
            executorService.execute(() -> save(o));
        }

    }


    private static void save(Integer integer) {
    }

    private static Integer getSomething() {
        return 1;
    }


}
