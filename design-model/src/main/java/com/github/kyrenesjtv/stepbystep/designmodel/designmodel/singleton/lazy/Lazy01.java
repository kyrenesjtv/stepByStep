package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.singleton.lazy;

/**
 * @author huojianxiong
 * @Description Lazy01 - 懒汉式
 * @Date 2022/3/5 01:11
 */
public class Lazy01 {

    private static Lazy01 lazy01 = null;

    private Lazy01() {
    }

    public static Lazy01 getInstance() {
        if (lazy01 == null) {
            lazy01 = new Lazy01();
        }
        return lazy01;
    }
}
