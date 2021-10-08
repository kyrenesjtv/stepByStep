package com.github.kyrenesjtv.multithread.geektime;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * 异步转同步
 *
 * @author huojianxiong
 * 2021/10/3 14:43
 */
public class GuardedObject<T> {

    //受保护的对象
    T obj;
    final Lock lock = new ReentrantLock();
    final Condition done = lock.newCondition();
    final int timeout = 1;
    //保存所有GuardedObject
    final static Map<Object,GuardedObject> gos = new ConcurrentHashMap<>();


    //静态方法创建GuardedObject
    static <K> GuardedObject create(K key){
        GuardedObject go = new GuardedObject();
        gos.put(key,go);
        return go;
    }

    //移除事件，证明完成了请求
    static <K,T> void fireEvent(K key , T obj){
        GuardedObject go = gos.remove(key);
        if(go != null){
            go.onChange(obj);
        }
    }


    //获取受保护的对象
    T get(Predicate p){
        lock.lock();
        try{
            //MESA管程经典写法
            while(!p.test(obj)){
                done.await(timeout, TimeUnit.SECONDS);
            }

        }catch (Exception e){

        }finally {
            lock.unlock();
        }
        return obj;
    }

    //事件通知
    void onChange(T obj){
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        }finally {
            lock.unlock();
        }
    }


}
