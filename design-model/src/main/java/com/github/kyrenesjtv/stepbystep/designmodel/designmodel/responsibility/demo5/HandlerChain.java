package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.responsibility.demo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huojianxiong
 * @Description HandlerChain
 * @Date 2022/3/31 11:06
 */
@Component
public class HandlerChain {
    @Autowired
    private List<IHandler5> handlers;


    public void handle() {
        for (IHandler5 handler : handlers) {
            handler.handle();
        }
    }
}
