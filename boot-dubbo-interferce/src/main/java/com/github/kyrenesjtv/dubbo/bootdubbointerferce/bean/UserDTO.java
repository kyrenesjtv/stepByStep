package com.github.kyrenesjtv.dubbo.bootdubbointerferce.bean;

import java.io.Serializable;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2021/5/31 19:45
 */
public class UserDTO implements Serializable {


    private String name;
    private Integer age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserDTO(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
