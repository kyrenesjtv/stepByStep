package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.proxy;

/**
 * @author huojianxiong
 * @Description UserControllerProxy  -  被代理类实现了接口，那么代理类也可以实现接口
 * @Date 2022/3/15 16:26
 */
public class UserControllerProxy implements IUserController {

    private UserController userController;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
    }

    @Override
    public UserVo login(String telephone, String password) {
        System.out.println("用户登录-前置操作");
        userController.login(telephone, password);
        System.out.println("用户登录-后置操作");
        return null;
    }

    @Override
    public UserVo register(String telephone, String password) {
        System.out.println("用户注册-前置操作");
        userController.register(telephone, password);
        System.out.println("用户注册-后置操作");
        return null;
    }
}
