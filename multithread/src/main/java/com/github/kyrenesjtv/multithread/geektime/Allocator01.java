package com.github.kyrenesjtv.multithread.geektime;

import java.util.ArrayList;
import java.util.List;

/**
 * 类似于账本，要有出和入的2本才能够操作
 *
 * @author huojianxiong
 * 2021/8/16 11:45
 */
public class Allocator01 {

    private List<Object> als = new ArrayList<>();

    // 一次性申请所有资源  
    synchronized boolean apply(Object from, Object to) {
        if (als.contains(from) || als.contains(to)) {
            return false;
        } else {
            als.add(from);
            als.add(to);
        }
        return true;
    }

    // 归还资源  
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
    }
    
}
