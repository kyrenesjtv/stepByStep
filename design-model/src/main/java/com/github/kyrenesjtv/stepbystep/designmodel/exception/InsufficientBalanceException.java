package com.github.kyrenesjtv.stepbystep.designmodel.exception;

/**
 * @author huojianxiong
 * @Description InsufficientBalanceException
 * @Date 2022/2/16 11:29
 */
public class InsufficientBalanceException extends Exception {
    private static final long serialVersionUID = -5753863518696877525L;

    public InsufficientBalanceException() {
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
