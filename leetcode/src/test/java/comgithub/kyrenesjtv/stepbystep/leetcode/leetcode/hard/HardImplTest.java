package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.hard;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/8/5 15:28
 */
public class HardImplTest {

    @Test
    public void reverseKGroup() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);
//        ListNode listNode7 = new ListNode(7);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
//        listNode5.next=listNode6;
//        listNode6.next=listNode7;

        HardImpl hard = new HardImpl();
        ListNode listNode = hard.reverseKGroup(listNode1, 3);
        System.out.println("1111");
    }
}