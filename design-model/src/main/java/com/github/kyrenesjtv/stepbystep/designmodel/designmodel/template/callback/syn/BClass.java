package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.template.callback.syn;

/**
 * @author huojianxiong
 * @Description BClass
 * @Date 2022/3/24 16:32
 */
public class BClass {

    public void process(ICallback callback) {
        System.out.println("BClass-before");
        callback.methodToCallback();
        System.out.println("BClass-after");
    }

}
