package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.template;

/**
 * @author huojianxiong
 * @Description Demo
 * @Date 2022/3/24 11:42
 */
public class Demo {
    public static void main(String[] args) {
        AbstractClass concreteClass1 = new ConcreteClass1();
        concreteClass1.templateMethod();

        AbstractClass concreteClass2 = new ConcreteClass2();
        concreteClass2.templateMethod();
    }

}
