package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.responsibility.demo5;

import org.springframework.stereotype.Service;

/**
 * @author huojianxiong
 * @Description HandlerA
 * @Date 2022/3/31 11:05
 */
@Service
public class HandlerB implements IHandler5 {
    @Override
    public void handle() {
        System.out.println("HandlerB-handle");
    }
}
