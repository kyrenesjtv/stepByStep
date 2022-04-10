package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.interpreter;

/**
 * @author huojianxiong
 * @Description NumberExpression
 * @Date 2022/4/10 17:06
 */
public class NumberExpression implements Expression {

    private long number;

    public NumberExpression(long number) {
        this.number = number;
    }

    public NumberExpression(String number) {
        this.number = Long.parseLong(number);
    }


    @Override
    public long interpret() {
        return this.number;
    }
}
