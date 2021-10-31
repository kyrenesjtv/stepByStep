package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延迟执行
 *
 * @author huojianxiong
 * 2021/8/29 17:50
 */
public class DelayObj implements Delayed {

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
