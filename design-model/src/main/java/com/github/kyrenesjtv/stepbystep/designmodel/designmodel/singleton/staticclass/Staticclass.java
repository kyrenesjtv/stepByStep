package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.singleton.staticclass;

/**
 * @author huojianxiong
 * @Description Staticclass - 通过静态内部类来实现单利。
 * 当Staticclass被加载的时候StaticclassHolder并不会被加载。只有Staticclass.getInstance的时候StaticclassHolder才会被加载到jvm，保证了唯一性
 * @Date 2022/3/5 01:17
 */
public class Staticclass {

    private static class StaticclassHolder {
        private static final Staticclass staticclass = new Staticclass();
    }

    public static Staticclass getInstance() {
        return StaticclassHolder.staticclass;
    }


}
