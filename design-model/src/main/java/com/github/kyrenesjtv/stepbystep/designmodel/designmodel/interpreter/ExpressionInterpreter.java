package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.interpreter;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huojianxiong
 * @Description ExpressionInterpreter
 * @Date 2022/4/10 17:12
 */
public class ExpressionInterpreter {


    public static long interpret(String expression) {
        Deque<Expression> numbers = new LinkedList<>();
        String[] elements = expression.split(" ");
        int length = elements.length;
        for (int i = 0; i < (length + 1) / 2; ++i) {
            numbers.addLast(new NumberExpression(elements[i]));
        }

        for (int i = (length + 1) / 2; i < length; ++i) {
            String operator = elements[i];
            boolean isValid = "+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator);
            if (!isValid) {
                throw new RuntimeException("Expression is invalid: " + expression);
            }
            Expression exp1 = numbers.pollFirst();
            Expression exp2 = numbers.pollFirst();
            Expression combinedExp = null;
            if (operator.equals("+")) {
                combinedExp = new AdditionExpression(exp1, exp2);
            } else if (operator.equals("-")) {
                combinedExp = new SubstractionExpression(exp1, exp2);
            } else if (operator.equals("*")) {
                combinedExp = new MultiplicationExpression(exp1, exp2);
            } else if (operator.equals("/")) {
                combinedExp = new DivisionExpression(exp1, exp2);
            }
            long result = combinedExp.interpret();
            numbers.addFirst(new NumberExpression(result));
        }
        if (numbers.size() != 1) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }
        return numbers.pop().interpret();
    }

    public static void main(String[] args) {
        long interpret = interpret("8 3 2 4 - + *");
        System.out.println(interpret);
    }
}