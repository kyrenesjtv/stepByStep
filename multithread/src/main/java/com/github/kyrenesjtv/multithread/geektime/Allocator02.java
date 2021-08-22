package com.github.kyrenesjtv.multithread.geektime;

import java.util.List;

/**
 * TODO 一句话描述
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
