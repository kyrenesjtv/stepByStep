package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.singleton.enums;

/**
 * @author huojianxiong
 * @Description EnumClass - 枚举。Java规范字规定，每个枚举类型及其定义的枚举变量在JVM中都是唯一的，
 * @Date 2022/3/5 01:23
 */
public enum EnumClass {
    /**/
    INSTANCE;

    private int count;

    public int doSomething() {
        return count++;
    }

}
