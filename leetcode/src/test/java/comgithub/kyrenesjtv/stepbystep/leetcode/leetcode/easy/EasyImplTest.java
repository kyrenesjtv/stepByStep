package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNode;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/7/22 17:46
 */
public class EasyImplTest {

    @Test
    public void twoSum() {
    }

    @Test
    public void reverse() {
    }

    @Test
    public void isPalindrome() {
    }

    @Test
    public void romanToInt() {
    }

    @Test
    public void longestCommonPrefix() {
        EasyImpl easy = new EasyImpl();
        String s = easy.longestCommonPrefix(new String[]{"qwertyu", "qwe", "qwer"});
        System.out.println(s);
    }

    @Test
    public void isValid() {
        String sss = "((()(())))";
        EasyImpl easy = new EasyImpl();
        boolean valid = easy.isValid(sss);
        System.out.println(valid);
    }

    @Test
    public void mergeTwoLists() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);

        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(4);

        listNode1.next=listNode2;
        listNode2.next=listNode4;

        listNode5.next=listNode6;
        listNode6.next=listNode7;

        EasyImpl easy = new EasyImpl();
        ListNode listNode = easy.mergeTwoLists(listNode1, listNode5);
        System.out.println("1111");

    }

    @Test
    public void removeDuplicates() {
        int[] mums = new int[]{1,1,1,2};
        EasyImpl easy = new EasyImpl();
        int i = easy.removeDuplicates(mums);
        System.out.println("111");
    }

    @Test
    public void removeElement() {
        int[] mums = new int[]{1,1,1,2};
        EasyImpl easy = new EasyImpl();
        int i = easy.removeElement(mums,1);
        System.out.println("111");
    }

}