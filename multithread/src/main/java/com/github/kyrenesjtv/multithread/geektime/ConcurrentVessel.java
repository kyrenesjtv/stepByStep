package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.*;

/**
 * 并发容器
 *
 * @author huojianxiong
 * 2021/8/29 17:39
 */
public class ConcurrentVessel {

    public static void main(String[] args) {
        //list
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        //加了lock unlock。 为什么要用lock ,可重入，不用排队 。
        strings.add("123");

        //map
        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>();
        stringStringConcurrentHashMap.put("123", "123");

        ConcurrentSkipListMap<String, String> stringStringConcurrentSkipListMap = new ConcurrentSkipListMap<>();
        stringStringConcurrentSkipListMap.put("123", "123");

        //set
        ConcurrentSkipListSet<String> strings1 = new ConcurrentSkipListSet<>();
        //最终调用了map
        strings1.add("123");
        CopyOnWriteArraySet<String> strings2 = new CopyOnWriteArraySet<>();
        //最终调用了list
        strings2.add("123");

        //queue

        //阻塞，双端
        LinkedBlockingDeque<String> strings3 = new LinkedBlockingDeque<>();
        strings3.add("123");

        //阻塞，单端
        ArrayBlockingQueue<String> strings4 = new ArrayBlockingQueue<String>(10);//有界
        strings4.add("123");
        LinkedBlockingQueue<String> strings5 = new LinkedBlockingQueue<>();
        strings5.add("123");
        SynchronousQueue<String> strings6 = new SynchronousQueue<>();
        strings6.add("123");
        PriorityBlockingQueue<String> strings7 = new PriorityBlockingQueue<>();
        strings7.add("123");
        DelayQueue<DelayObj> strings8 = new DelayQueue<DelayObj>();
        strings8.add(new DelayObj());

        //非阻塞 单端
        ConcurrentLinkedQueue<String> strings9 = new ConcurrentLinkedQueue<>();
        strings9.add("123");

        //非阻塞 双端
        ConcurrentLinkedDeque<String> strings10 = new ConcurrentLinkedDeque<>();
        strings10.add("123");

        
    }


}
