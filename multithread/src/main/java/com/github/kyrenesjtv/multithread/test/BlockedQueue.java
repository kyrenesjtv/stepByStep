package com.github.kyrenesjtv.multithread.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/8/16 14:04
 */
public class BlockedQueue<T> {
    final Lock lock = new ReentrantLock();
    //条件变量: 队列不满
    final Condition notFull = lock.newCondition();
    //条件变量: 队列不空
    final Condition notEmpty = lock.newCondition();
    final int size = 10;
    final List<T> list = new ArrayList<>();

    //入队
    void enq(T t) {
        lock.lock();
        try {
            //队列已满
            while (list.size() == size) {
                //等待队列不满
                notFull.await();
            }
            notEmpty.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    //入队
    void deq() {
        lock.lock();
        try {
            //队列为空
            while (list.isEmpty()) {
                //等待队列不空
                notEmpty.await();
            }
            notFull.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

}
