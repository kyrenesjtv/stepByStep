package com.github.kyrenesjtv.multithread.video;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2021/8/22 22:48
 */
public class Runnable01 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我在看代码====" + i);
        }
    }


    public static void main(String[] args) {
        //feature-v1.0.1
        //fixbug-v1.0.1
        Runnable01 myThread01 = new Runnable01();
        Thread thread = new Thread(myThread01);
        thread.start();

        for (int i = 0; i < 30; i++) {
            System.out.println("我在学习多线程====" + i);
        }
    }

}
