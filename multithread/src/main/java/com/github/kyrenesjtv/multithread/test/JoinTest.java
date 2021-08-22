package com.github.kyrenesjtv.multithread.test;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/8/16 11:13
 */
public class JoinTest {

    static int x1 = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread B = new Thread(() -> {
            // 此处对共享变量var修改
            x1 = 66;
        });
        // 例如此处对共享变量修改，
        // 则这个修改结果对线程B可见
        // 主线程启动子线程
        B.start();
        B.join();
        // 子线程所有对共享变量的修改
        // 在主线程调用B.join()之后皆可见
        // 此例中，var==66
        System.out.println("变量x1 =====：" + x1);
    }

}
