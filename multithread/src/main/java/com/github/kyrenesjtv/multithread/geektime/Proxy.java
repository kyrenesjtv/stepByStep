package com.github.kyrenesjtv.multithread.geektime;

/**
 * interrput()和标志位来优雅的结束线程
 *
 * @author huojianxiong
 * 2021/10/4 21:46
 */
public class Proxy {

    //线程终止标志位
    volatile boolean terminated = false;
    boolean started = false;
    //采集线程
    Thread rptThread;

    //启动采集功能
    synchronized void start(){
        //不允许多个线程进行采集
        if(started){
            return;
        }
        started = true;
        terminated = false;
        rptThread = new Thread( ()-> {
            while (!terminated){
                //省略采集，回传
                report();
                //每隔2S 进行采集和回传
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    //重新设置线程中断状态
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }

            }
            //到此处，证明线程执行完
            started = false;
        });
        rptThread.start();
    }

    //终止采集功能
    synchronized void stop(){
        //设置终端标识位
        terminated = true;
        //终端线程
        rptThread.interrupt();
    }

    private void report() {
    }


}
