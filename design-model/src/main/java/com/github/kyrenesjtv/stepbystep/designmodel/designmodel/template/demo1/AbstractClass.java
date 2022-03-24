package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.template.demo1;

/**
 * @author huojianxiong
 * @Description AbstractClass
 * @Date 2022/3/24 11:36
 */
public abstract class AbstractClass {

    public final void templateMethod() {
        method1();
        method2();
    }

    protected abstract void method2();

    protected abstract void method1();

}
