package com.github.kyrenesjtv.dubbo.bootdubboprovider.serrvice;

import com.github.kyrenesjtv.dubbo.bootdubbointerferce.bean.UserDTO;
import com.github.kyrenesjtv.dubbo.bootdubbointerferce.service.UserSerrvice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2021/5/31 19:46
 */
@Service
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = UserSerrvice.class
        ,timeout = 2000 , retries = 3)
public class UserServiceImpl implements UserSerrvice {

    @Override
    public List<UserDTO> getUserList() {
        UserDTO userDTO1 = new UserDTO("张三", 1, "地址1");
        UserDTO userDTO2 = new UserDTO("王五", 1, "地址2");
        List<UserDTO> userDTOS = new ArrayList<>();
        userDTOS.add(userDTO1);
        userDTOS.add(userDTO2);
        return userDTOS;
    }
}
