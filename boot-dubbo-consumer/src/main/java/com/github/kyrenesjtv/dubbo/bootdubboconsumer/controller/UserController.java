package com.github.kyrenesjtv.dubbo.bootdubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.kyrenesjtv.dubbo.bootdubbointerferce.bean.UserDTO;
import com.github.kyrenesjtv.dubbo.bootdubbointerferce.service.UserSerrvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2021/5/31 20:01
 */
@RequestMapping("/user")
@RestController
public class UserController {

    //retries：重试次数 timeout：超时时间 loadbalance：负载均衡策略
    //version：版本号 mock：服务降级
    // parameters = {"sayHello.timeout", "3000", "sayHello2.timeout", "5000"} 针对方法级别
    @Reference(interfaceClass = UserSerrvice.class)
    private UserSerrvice userSerrvice;

    @RequestMapping("/getAllUser")
    private List<UserDTO> getAllUser(){
        return userSerrvice.getUserList();
    }

}
