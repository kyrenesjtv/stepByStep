package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/8/29 15:03
 */
public class LockCondition {

    //可重入锁
    class X01 {
        private final Lock lock = new ReentrantLock();
        int value;

        public int getValue() {
            lock.lock();
            try {
                return value;
            } finally {
                lock.unlock();
            }
        }

        public void setValue(int value) {
            lock.lock();
            try {
                value = value;
            } finally {
                lock.unlock();
            }
        }

        public int addOne() {
            lock.lock();
            try {
                return value = value + 1;
            } finally {
                lock.unlock();
            }
        }

    }

    //公平锁
    class X02 {
        private final Lock reentrantLock = new ReentrantLock(true);
    }

    public static void main(String[] args) {


    }
}
