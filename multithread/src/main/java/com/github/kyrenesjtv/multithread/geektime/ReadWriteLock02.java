package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁的降级 - 写锁变成读锁
 *
 * @author huojianxiong
 * 2021/8/29 16:13
 */
public class ReadWriteLock02 {

    Object data;
    volatile boolean cacheValid;
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    //读锁
    final Lock r = rwl.readLock();
    //写锁
    final Lock w = rwl.writeLock();

    void processCacheData() {
        r.lock();
        if (!cacheValid) {
            //释放读锁，因为不允许读锁的升级
            r.unlock();
            //获取写锁
            w.lock();
            try {
                //再次检查
                if (!cacheValid) {
                    //操作
                    cacheValid = true;
                }
                //释放写锁前，降级成读锁
                r.lock();
            } finally {
                //释放写锁
                w.unlock();
            }
        }
        //释放读锁
        try {

        } finally {
            r.unlock();
        }
    }
}
