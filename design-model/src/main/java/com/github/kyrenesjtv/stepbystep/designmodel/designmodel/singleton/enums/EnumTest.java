package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.singleton.enums;

/**
 * @author huojianxiong
 * @Description EnumTest
 * @Date 2022/3/5 01:33
 */
public enum EnumTest {

    RED(1, "红色");

    private int id;
    private String msg;

    EnumTest(int i, String msg) {
        this.id = i;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }
}
