package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.adaptor;

/**
 * @author huojianxiong
 * @Description ObjAdaptor - 对象适配器，传入被适配类
 * @Date 2022/3/16 18:00
 */
public class ObjAdaptor implements ITarget {

    private Adaptee adaptee;

    public ObjAdaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        System.out.println("ObjAdaptor-Adaptee-fb");
    }

    @Override
    public void f3() {
        adaptee.fc();
    }
}
