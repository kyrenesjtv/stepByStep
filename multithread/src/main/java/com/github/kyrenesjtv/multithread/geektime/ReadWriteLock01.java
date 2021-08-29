package com.github.kyrenesjtv.multithread.geektime;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁 - 读锁不影响并发， 只允许一个写锁进行写操作
 * <p>
 * 读写锁不支持锁的升级，但是支持锁的降级。写锁只有一把，会引起死锁
 *
 * @author huojianxiong
 * 2021/8/29 15:59
 */
public class ReadWriteLock01<K, V> {

    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    //读锁
    final Lock r = rwl.readLock();
    //写锁
    final Lock w = rwl.writeLock();

    //读缓存
    V get(K key) {
        r.lock();
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    //写缓存
    V put(K key, V value) {
        w.lock();
        try {
            m.put(key, value);
            return value;
        } finally {
            w.unlock();
        }
    }

    //读缓存01 - 读锁升级成写锁
    V get01(K key) {
        V v = null;
        //读缓存
        r.lock();
        try {
            v = m.get(key);
        } finally {
            r.unlock();
        }
        //缓存未命中，返回
        if (v == null) {
            return v;
        }
        //查缓存中不存在，查询数据库
        w.lock();
        try {
            //再次验证
            //其他线程可能查过数据库
            v = m.get(key);
            if (v == null) {
                //查数据库
                // v = jdbc 操作结果
                m.put(key, v);
            }
        } finally {
            w.unlock();
        }
        return v;
    }


}
