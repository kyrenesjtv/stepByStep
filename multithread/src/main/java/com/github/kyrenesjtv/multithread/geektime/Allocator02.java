package com.github.kyrenesjtv.multithread.geektime;

import java.util.List;

/**
 * 类似于账本，要有出和入的2本才能够操作，升级搬
 *
 * @author huojianxiong
 * 2021/8/16 13:53
 */
public class Allocator02 {
    private List als;

    // 一次性申请所有资源 
    synchronized void apply(Object from, Object to) {
        //经典写法。wait()要写在while里面
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        als.add(from);
        als.add(to);
    }

    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }

}
