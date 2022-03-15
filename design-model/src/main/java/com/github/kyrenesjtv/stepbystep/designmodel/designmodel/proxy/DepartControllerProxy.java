package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.proxy;

/**
 * @author huojianxiong
 * @Description DepartControllerProxy
 * @Date 2022/3/15 16:35
 */
public class DepartControllerProxy extends DepartController {

    @Override
    public void insert(String departName) {
        System.out.println("注册了新部门-前置操作");
        super.insert("123");
        System.out.println("注册了新部门-后置操作");
    }
}
