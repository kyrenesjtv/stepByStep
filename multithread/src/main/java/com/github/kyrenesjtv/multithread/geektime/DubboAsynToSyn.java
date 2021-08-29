package com.github.kyrenesjtv.multithread.geektime;

import javax.xml.ws.Response;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Dubbo 异步转同步
 *
 * @author huojianxiong
 * 2021/8/29 15:13
 */
public class DubboAsynToSyn {

    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();
    private Response response;

    //调用方通过该方法进行等待
    Object get(int timeout) throws TimeoutException, InterruptedException {
        long start = System.nanoTime();
        lock.lock();
        try {
            while (!isDone()) {
                //进行等待
                done.await();
                long cur = System.nanoTime();
                if (isDone() || cur - start > timeout) {
                    break;
                }
            }


        } finally {
            lock.unlock();
        }

        if (!isDone()) {
            throw new TimeoutException();
        }
        //        return returnFromResponse(); 这个是dubbo源码里面返回的方法
        return 1;
    }

    //rpc结果是否已经返回
    boolean isDone() {
        return response != null;
    }

    //rpc结果返回的时候调用该方法
    private void doReceived(Response res) {
        lock.lock();
        try {
            response = res;
            if (done != null) {
                done.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

}
