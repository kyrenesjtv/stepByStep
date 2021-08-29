package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.locks.StampedLock;

/**
 * 写锁，悲观读，乐观读
 * 写锁，悲观读都会有一个stamp(类似版本号)，这个需要更新然后unlock
 *
 * @author huojianxiong
 * 2021/8/29 16:44
 */
public class StampedLock01 {
    private int x, y;
    final StampedLock sl = new StampedLock();

    //悲观读
    void read() {
        long stamp = sl.readLock();
        try {
            //业务
        } finally {
            sl.unlockRead(stamp);
        }
    }

    //写
    void write() {
        long l = sl.writeLock();
        try {
            //业务代码
        } finally {
            sl.unlockWrite(l);
        }
    }

    //乐观读
    void opRead() {
        //乐观读的stamp,其实没用。只有升级成悲观读的时候才会用。
        long stamp = sl.tryOptimisticRead();
    }

    //乐观升级悲观
    double distanceFromOrigin() {
        //乐观
        long stamp = sl.tryOptimisticRead();
        //读的过程中有可能被修改
        int curX = x, curY = y;
        //判断执行读操作期间，是否存在写操作。如果操作了stamp是会变的
        if (!sl.validate(stamp)) {
            //升级为悲观读
            stamp = sl.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(curX * curX + curY * curY);
    }

}
