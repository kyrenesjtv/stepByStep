package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.responsibility.demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huojianxiong
 * @Description HandlerChain
 * @Date 2022/3/31 11:06
 */
public class HandlerChain {
    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    public void handle() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle();
            if (handled) {
                break;
            }
        }
    }
}
