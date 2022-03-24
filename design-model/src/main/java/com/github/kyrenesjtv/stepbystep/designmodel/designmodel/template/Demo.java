package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.template;

import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.template.demo3.AbstractClass3;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.template.demo3.CallBack1;

/**
 * @author huojianxiong
 * @Description Demo
 * @Date 2022/3/24 11:42
 */
public class Demo {
    public static void main(String[] args) {
//        AbstractClass concreteClass1 = new ConcreteClass1();
//        concreteClass1.templateMethod();
//
//        AbstractClass concreteClass2 = new ConcreteClass2();
//        concreteClass2.templateMethod();


//        AbstractClass2 concreteClass21 = new ConcreteClass21();
//        concreteClass21.templateMethod1();
//        concreteClass21.templateMethod2();

        AbstractClass3 concreteClass3 = new AbstractClass3();
        concreteClass3.templateMethod1(new CallBack1() {
            @Override
            public void method1() {
                System.out.println("CallBack1-method1");
            }

            @Override
            public void method2() {
                System.out.println("CallBack1-method2");
            }
        });

    }

}
