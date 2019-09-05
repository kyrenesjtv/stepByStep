package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/9/5 15:42
 */
public class MyStack_deque {

    Deque<Integer> deque ;

    /** Initialize your data structure here. */
    public MyStack_deque() {
        deque = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque.pollLast();
    }

    /** Get the top element. */
    public int top() {
        return deque.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}
