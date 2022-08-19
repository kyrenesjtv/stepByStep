package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 并行化
 *
 * @author huojianxiong
 * 2021/8/29 21:43
 */
public class CompletetableFuture01 {


    public static void main(String[] args) {
        CompletableFuture f1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1:洗水壶...");
            sleep(1, TimeUnit.SECONDS);
            System.out.println("T1:烧开水...");
            sleep(15, TimeUnit.SECONDS);
        });

        CompletableFuture f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2:洗茶壶...");
            sleep(1, TimeUnit.SECONDS);
            System.out.println("T2:洗茶杯...");
            sleep(2, TimeUnit.SECONDS);
            System.out.println("T2:拿茶叶...");
            sleep(1, TimeUnit.SECONDS);
            sleep(1, TimeUnit.SECONDS);
            sleep(2, TimeUnit.SECONDS);
            sleep(3, TimeUnit.SECONDS);
            return "龙井";
        });

        CompletableFuture f3 = f1.thenCombine(f2, (f1v, f2v) -> {
            System.out.println("T1:拿到茶叶:" + f2v);
            System.out.println("T1:泡茶...");
            return "上茶:" + f2v;
        });

        //        System.out.println(f3.join());


        //描述串行关系
        /** <void>无返回 <r>有返回  fn可以接受参数 、consumer 支持参数 action 不支持参数、
         CompletionStage<R> thenApply (fn);
         CompletionStage<R> thenApplyAsync (fn);
         CompletionStage<void> thenAccept (consumer);
         CompletionStage<void> thenAcceptAsync (consumer);
         CompletionStage<void> thenRun (action);
         CompletionStage<void> thenRunAsync (action);
         CompletionStage<R> thenCompose (fn);
         CompletionStage<R> thenComposeAsync (fn);
         */


        //描述AND 汇聚关系
        /**
         CompletionStage<R> thenCombine(other, fn);
         CompletionStage<R> thenCombineAsync(other, fn);
         CompletionStage<Void> thenAcceptBoth(other, consumer);
         CompletionStage<Void> thenAcceptBothAsync(other, consumer);
         CompletionStage<Void> runAfterBoth(other, action);
         CompletionStage<Void> runAfterBothAsync(other, action);
         */

        //描述 OR 汇聚关系
        /**
         CompletionStage applyToEither(other, fn);
         CompletionStage applyToEitherAsync(other, fn);
         CompletionStage acceptEither(other, consumer);
         CompletionStage acceptEitherAsync(other, consumer);
         CompletionStage runAfterEither(other, action);
         CompletionStage runAfterEitherAsync(other, action);
         */


        CompletableFuture<Integer> f0 = CompletableFuture.supplyAsync(() -> (7 / 0)).thenApply(r -> r * 10);
        System.out.println(f0.join());

        //异常处理
        /**
         CompletionStage exceptionally(fn);
         CompletionStage<R> whenComplete(consumer);
         CompletionStage<R> whenCompleteAsync(consumer);
         CompletionStage<R> handle(fn);
         CompletionStage<R> handleAsync(fn);
         */

    }

    static void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
        }
    }
}
