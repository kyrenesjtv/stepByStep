package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.template.demo3;

/**
 * @author huojianxiong
 * @Description AbstractClass
 * @Date 2022/3/24 11:36
 */
public class AbstractClass3 {

    public void templateMethod1(CallBack1 callBack1) {
        System.out.println("AbstractClass3-before");
        callBack1.method1();
        callBack1.method2();
        System.out.println("AbstractClass3-befor");
    }

    public void templateMethod2(CallBack2 callBack2) {
        callBack2.method3();
        callBack2.method4();
    }


}
