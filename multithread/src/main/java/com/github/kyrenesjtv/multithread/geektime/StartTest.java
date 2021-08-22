package com.github.kyrenesjtv.multithread.geektime;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/8/16 11:11
 */
public class StartTest {

    static int x1 = 0;
    

    public static void main(String[] args) {
        Thread B = new Thread(() -> {
            // 主线程调用B.start()之前
            // 所有对共享变量的修改，此处皆可见
            // 此例中，var==77
            System.out.println("变量x1 =====：" + x1);
        });
        // 此处对共享变量var修改
        x1 = 77;
        // 主线程启动子线程
        B.start();
    }

}
