package com.github.kyrenesjtv.multithread.geektime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/10/3 0:51
 */
public class SafeDateFormat {


    //定义ThreadLocal变量
    static final ThreadLocal<DateFormat> tl = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    static DateFormat get() {
        return tl.get();
    }

    //不同线程执行下面代码
    //返回的df是不同的
    //    DateFormat df = SafeDateFormat.get()；

}
