package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.hungry;

/**
 * @author huojianxiong
 * @Description Hungry - 单例模式，饿汉式
 * @Date 2022/3/5 01:07
 */
public class Hungry {

    private static final Hungry hungry = new Hungry();

    public static Hungry getInstance() {
        return hungry;
    }
}
