package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.template.callback.asyn;

/**
 * @author huojianxiong
 * @Description BClass
 * @Date 2022/3/24 16:32
 */
public class BClass {

    public void process(ICallback callback) {
        System.out.println("before");
        new Thread(() -> {
            callback.methodToCallback();
        }).start();
        System.out.println("after");
    }

}
