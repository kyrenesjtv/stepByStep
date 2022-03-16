package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.decorator;

import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.proxy.UserVo;

/**
 * @author huojianxiong
 * @Description UserController
 * @Date 2022/3/15 16:25
 */
public class UserControllerDecorator implements IUserController {

    private IUserController iUserController;

    public UserControllerDecorator(IUserController iUserController) {
        this.iUserController = iUserController;
    }

    @Override
    public UserVo login(String telephone, String password) {
        iUserController.login(telephone, password);
        System.out.println("登录-功能增强-验证码");
        return null;
    }

    @Override
    public UserVo register(String telephone, String password) {
        iUserController.register(telephone, password);
        System.out.println("注册-功能增强-验证码");
        return null;
    }
}
