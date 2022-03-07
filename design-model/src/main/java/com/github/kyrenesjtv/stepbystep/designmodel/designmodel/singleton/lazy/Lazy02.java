package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.singleton.lazy;

/**
 * @author huojianxiong
 * @Description Lazy01 - 懒汉式
 * @Date 2022/3/5 01:11
 */
public class Lazy02 {

    private static Lazy02 lazy01 = null;

    private Lazy02() {
    }

    public static synchronized Lazy02 getInstance() {
        if (lazy01 == null) {
            lazy01 = new Lazy02();
        }
        return lazy01;
    }
}
