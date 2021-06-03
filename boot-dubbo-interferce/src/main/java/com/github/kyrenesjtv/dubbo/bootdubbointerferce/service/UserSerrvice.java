package com.github.kyrenesjtv.dubbo.bootdubbointerferce.service;

import com.github.kyrenesjtv.dubbo.bootdubbointerferce.bean.UserDTO;

import java.util.List;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2021/5/31 19:45
 */
public interface UserSerrvice {


    List<UserDTO> getUserList();
}
