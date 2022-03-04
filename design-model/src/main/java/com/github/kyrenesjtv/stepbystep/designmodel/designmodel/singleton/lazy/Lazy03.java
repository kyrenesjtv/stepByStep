package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.singleton.lazy;

/**
 * @author huojianxiong
 * @Description Lazy01 - 懒汉式
 * @Date 2022/3/5 01:11
 */
public class Lazy03 {

    private static Lazy03 lazy01 = null;

    public static Lazy03 getInstance() {
        if (lazy01 == null) {
            synchronized (Lazy03.class) {
                if (lazy01 == null) {
                    lazy01 = new Lazy03();
                }
            }
        }
        return lazy01;
    }
}
