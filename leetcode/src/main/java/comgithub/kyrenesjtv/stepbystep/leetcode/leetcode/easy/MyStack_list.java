package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/9/5 15:42
 */
public class MyStack_list {

    List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public MyStack_list() {
        list = new ArrayList();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        list.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Integer integer = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return integer;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return list.get(list.size() - 1);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return list.isEmpty();
    }
}
