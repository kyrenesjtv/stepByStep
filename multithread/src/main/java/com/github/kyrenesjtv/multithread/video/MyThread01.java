package com.github.kyrenesjtv.multithread.video;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2021/8/22 22:48
 */
public class MyThread01 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我在看代码===="+i);
        }
    }


    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        Thread thread = new Thread(myThread01);
        thread.start();

        for (int i = 0 ; i< 30 ; i++){
            System.out.println("我在学习多线程===="+i);
        }
    }

}
