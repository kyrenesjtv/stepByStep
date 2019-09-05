package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

import java.util.Stack;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/9/5 16:16
 */
public class MyQueue_stack {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public MyQueue_stack() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        Integer pop = outStack.pop();
        while(!outStack.isEmpty()){
            inStack.push(outStack.pop());
        }
        return pop;
    }

    /** Get the front element. */
    public int peek() {
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        Integer peek = outStack.peek();
        while(!outStack.isEmpty()){
            inStack.push(outStack.pop());
        }
        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty();
    }


}
