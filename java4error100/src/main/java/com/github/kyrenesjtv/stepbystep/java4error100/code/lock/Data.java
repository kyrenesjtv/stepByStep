package com.github.kyrenesjtv.stepbystep.java4error100.code.lock;

import lombok.Getter;

class Data {
    @Getter
    private static int counter = 0;
    private static Object lock = new Object();

    public static int reset() {
        counter = 0;
        return counter;
    }

    public synchronized void wrong() {
        //counter是静态的，容易被多个实例调用。所以需要再对lock的操作上加上对象锁
        synchronized (lock) {
            counter++;
        }
    }
}