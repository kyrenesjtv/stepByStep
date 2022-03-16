package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.adaptor;

/**
 * @author huojianxiong
 * @Description ClassAdaptor - 类适配器，基于继承，定义新的接口给调用者
 * @Date 2022/3/16 17:52
 */
public class ClassAdaptor extends Adaptee implements ITarget {
    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        System.out.println("ClassAdaptor-Adaptee-fb");
    }

    @Override
    public void f3() {
        super.fc();
    }
}
