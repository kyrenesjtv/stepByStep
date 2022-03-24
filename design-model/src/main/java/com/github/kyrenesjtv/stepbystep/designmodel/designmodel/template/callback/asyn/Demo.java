package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.template.callback.asyn;

/**
 * @author huojianxiong
 * @Description Demo
 * @Date 2022/3/24 16:33
 */
public class Demo {
    public static void main(String[] args) {
        BClass b = new BClass();
        //这边其实就相当于一个实现类
        b.process(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("123");
        });
    }
}
