package com.github.kyrenesjtv.stepbystep.designmodel.exception;

import java.net.UnknownHostException;

/**
 * @author huojianxiong
 * @Description InsufficientBalanceException
 * @Date 2022/2/16 11:29
 */
public class IdGeneratorException extends Exception {
    private static final long serialVersionUID = -5753863518696877525L;

    public IdGeneratorException() {
    }

    public IdGeneratorException(String message) {
        super(message);
    }

    public IdGeneratorException(String s, UnknownHostException e) {
        super(s, e);
    }
}
