package com.github.kyrenesjtv.stepbystep.designmodel.exception;

/**
 * @author huojianxiong
 * @Description InvalidAmountException
 * @Date 2022/2/16 11:29
 */
public class InvalidAmountException extends Exception {
    private static final long serialVersionUID = -426795239731897941L;

    public InvalidAmountException() {
    }

    public InvalidAmountException(String message) {
        super(message);
    }
}
