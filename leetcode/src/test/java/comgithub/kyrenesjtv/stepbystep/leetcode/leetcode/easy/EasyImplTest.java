package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNode;
import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.middle.TreeNode;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/7/22 17:46
 */
public class EasyImplTest {

    @Test
    public void test01() {
        //链表反转
        ListNode listNode = new ListNode(2);
        if(listNode == null){
            return ;
        }// 1 2 3 4 5
        ListNode curr = listNode;// 123
        ListNode pre = null;//
        ListNode next = null;//
        while(curr != null){
            next = curr.next;//next 23。3。next null
            curr.next = pre;//curr 1 next 23。curr 21 next 3。curr 321,next null
            pre=curr;//pre 1 。pre 21。 pre 321
            curr=next;//curr 23。curr 3。curr null
        }
    }

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

        listNode1.next = listNode2;
        listNode2.next = listNode4;

        listNode5.next = listNode6;
        listNode6.next = listNode7;

        EasyImpl easy = new EasyImpl();
        ListNode listNode = easy.mergeTwoLists(listNode1, listNode5);
        System.out.println("1111");

    }

    @Test
    public void removeDuplicates() {
        int[] mums = new int[]{1, 1, 1, 2};
        EasyImpl easy = new EasyImpl();
        int i = easy.removeDuplicates(mums);
        System.out.println("111");
    }

    @Test
    public void removeElement() {
        int[] mums = new int[]{1, 1, 1, 2};
        EasyImpl easy = new EasyImpl();
        int i = easy.removeElement(mums, 1);
        System.out.println("111");
    }

    @Test
    public void strStr() {
        EasyImpl easy = new EasyImpl();
        int i = easy.strStr("qwertyuiop", "we");
        System.out.println("111");
    }

    @Test
    public void reverseList() {
        EasyImpl easy = new EasyImpl();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        //        ListNode listNode4 = new ListNode(4);
        //        ListNode listNode5 = new ListNode(5);
        //        ListNode listNode6 = new ListNode(6);
        //        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        //        listNode3.next=listNode4;
        //        listNode4.next=listNode5;
        //        listNode5.next=listNode6;
        //        listNode6.next=listNode7;
        ListNode node = easy.reverseList(listNode1);
        System.out.println("1111");
    }

    @Test
    public void KthLargest() {
        int[] ints = new int[]{1, 3, 5, 7, 9};
        KthLargest_List kthLargest_priorityQueue = new KthLargest_List(3, ints);
        kthLargest_priorityQueue.add(8);

        //        List<Integer> list = new ArrayList<>();
        //        list.add(2);
        //        list.add(4);
        //        list.add(3);
        //        list.add(6);
        //        list.add(5);

        System.out.println("1111");

    }


    @Test
    public void maxSlidingWindow() {
        int[] ints = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        EasyImpl easy = new EasyImpl();
        int[] ints1 = easy.maxSlidingWindow(ints, 3);
        System.out.println("1111");

    }

    @Test
    public void isAnagram() {
        EasyImpl easy = new EasyImpl();
        Boolean result = easy.isAnagram("abcde", "edcba");
        System.out.println("1111");

    }

    @Test
    public void threeSum() {
        int[] ints = new int[]{1, 3, -1, -3, 5, 3, -6, 7, 7};
        EasyImpl easy = new EasyImpl();
        List<List<Integer>> result = easy.threeSum(ints);
        System.out.println("1111");

    }

    @Test
    public void majorityElement() {
        EasyImpl easy = new EasyImpl();
        Integer result = easy.majorityElement(new int[]{2,2,1,1,1,2,2});
        System.out.println(result);
    }

    @Test
    public void maxProfit() {
        EasyImpl easy = new EasyImpl();
        Integer result = easy.maxProfit(new int[]{7,1,5,3,6,4});
//        Integer result = easy.maxProfit(new int[]{1,2,3,4,5});
        System.out.println(result);
    }

    @Test
    public void maxDepth() {
        TreeNode treeNode = new TreeNode(3);

        TreeNode treeNode1 = new TreeNode(9);

        TreeNode treeNode2 = new TreeNode(20);

        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);

//        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        EasyImpl easy = new EasyImpl();
//        int i = easy.maxDepth(treeNode);
        int i = easy.minDepth(treeNode);
        System.out.println(i);
    }


    private static void insertionSort(List<Integer> a, int n) {
        if (n <= 0) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a.get(i);
            int j = i - 1;
            for (; j >= 0; j--) {
                //进行数据交换
                if (a.get(j) < value) {
                    a.set(j + 1, a.get(j));
                } else {
                    break;
                }
            }
            //插入数据
            a.set(j + 1, value);
        }
    }


    private static void insertionSort(int[] a, int n) {
        if (n <= 0) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                //进行数据交换
                if (a[j] < value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //插入数据
            a[j + 1] = value;
        }
    }

}