package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.template.demo2;

/**
 * @author huojianxiong
 * @Description AbstractClass
 * @Date 2022/3/24 11:36
 */
public abstract class AbstractClass2 {

    public final void templateMethod1() {
        method1();
        method2();
    }

    public final void templateMethod2() {
        method3();
        method4();
    }

    protected abstract void method1();

    protected abstract void method2();

    protected abstract void method3();

    protected abstract void method4();


}
