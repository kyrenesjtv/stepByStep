package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.decorator;

import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.proxy.UserVo;

/**
 * @author huojianxiong
 * @Description UserController
 * @Date 2022/3/15 16:25
 */
public class UserController implements IUserController {
    @Override
    public UserVo login(String telephone, String password) {
        System.out.println("用户登录");
        return null;
    }

    @Override
    public UserVo register(String telephone, String password) {
        System.out.println("用户注册");
        return null;
    }
}
