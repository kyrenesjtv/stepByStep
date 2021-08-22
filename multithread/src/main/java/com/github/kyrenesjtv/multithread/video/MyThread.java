package com.github.kyrenesjtv.multithread.video;


/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2021/8/22 22:44
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我在看代码===="+i);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        for (int i = 0 ; i< 30 ; i++){
            System.out.println("我在学习多线程===="+i);
        }
    }

}
