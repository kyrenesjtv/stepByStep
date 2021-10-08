package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.atomic.AtomicReference;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/10/2 23:34
 */
public class SafeWM {

    final int upper;

    final int lower;

    SafeWM(int upper, int lower) {
        this.upper = upper;
        this.lower = lower;
    }

    final AtomicReference<SafeWM> rf = new AtomicReference<>(new SafeWM(0,0));

    //设置库存上限
    void setUpper(int v){
        while (true){
            SafeWM sf = rf.get();
            if(v < sf.lower){
                throw new IllegalArgumentException();
            }
            SafeWM safeWM = new SafeWM(v, sf.lower);
            //不一样更新，一样不更新
            if(rf.compareAndSet(sf,safeWM)){
                return;
            }
        }
    }



}
