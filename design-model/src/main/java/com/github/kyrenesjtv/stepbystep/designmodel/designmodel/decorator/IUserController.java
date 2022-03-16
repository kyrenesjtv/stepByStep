package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.decorator;

import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.proxy.UserVo;

/**
 * @author huojianxiong
 * @Description IUserController
 * @Date 2022/3/15 16:25
 */
public interface IUserController {

    UserVo login(String telephone, String password);

    UserVo register(String telephone, String password);

}
