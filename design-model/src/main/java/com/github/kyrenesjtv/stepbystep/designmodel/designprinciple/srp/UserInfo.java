package com.github.kyrenesjtv.stepbystep.designmodel.designprinciple.srp;

/**
 * @author huojianxiong
 * @description 单依职责的类具体是看场景的。 比如这个类，在平常的社交软件场景中，地址信息是可以放在一起的。但是在电商场景中却是不够单一的，需要划分出去
 * @data 16:14 2022/2/20
 **/
public class UserInfo {
    private long userId;
    private String username;
    private String email;
    private String telephone;
    private long createTime;
    private long lastLoginTime;
    private String avatarUrl;

    private String provinceOfAddress; // 省
    private String cityOfAddress; // 市
    private String regionOfAddress; // 区
    private String detailedAddress; // 详细地址
}