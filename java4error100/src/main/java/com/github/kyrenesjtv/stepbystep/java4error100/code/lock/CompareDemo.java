package com.github.kyrenesjtv.stepbystep.java4error100.code.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huojianxiong
 * @Description ThreadSecurity 关于操作synchronized
 * @Date 2022/2/17 11:42
 */
@Slf4j
public class CompareDemo {

    volatile int a = 1;
    volatile int b = 1;

    public synchronized void add() {
        log.info("add start");
        for (int i = 0; i < 10000; i++) {
            a++;
            b++;
        }
        log.info("add end");
    }

    public synchronized void compare() {
        log.info("compare start");
        for (int i = 0; i < 10000; i++) {
            //a 始终等于 b？
            if (a < b) {
                log.info("a:{},b:{},{}", a, b, a < b);
            }
        }
        log.info("compare end");
    }

    public static void main(String[] args) {
        log.info("123");
        CompareDemo threadSecurity = new CompareDemo();
        //2个方法都加上synchronized，解决问题。要清楚锁和保护的对象是不是一个层面的
        new Thread(() -> threadSecurity.add()).start();
        new Thread(() -> threadSecurity.compare()).start();
        log.info("456");
    }

}
