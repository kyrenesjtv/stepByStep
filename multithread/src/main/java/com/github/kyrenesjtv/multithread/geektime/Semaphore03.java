package com.github.kyrenesjtv.multithread.geektime;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 限流器 - 多个线程访问临界区（并发的代码块） - 实现对象池
 *
 * @author huojianxiong
 * 2021/8/29 15:46
 */
public class Semaphore03<T, R> {

    final List<T> pool;
    final Semaphore sem;

    Semaphore03(int size, T t) {
        pool = new Vector<T>() {
            private static final long serialVersionUID = -8167819363284948238L;
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    //利用对象池的对象，调用func
    R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) {
        //创建对象池
        Semaphore03<Long, String> pool = new Semaphore03<Long, String>(10, 2L);
        try {
            pool.exec(t -> {
                System.out.println(t);
                return t.toString();
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
