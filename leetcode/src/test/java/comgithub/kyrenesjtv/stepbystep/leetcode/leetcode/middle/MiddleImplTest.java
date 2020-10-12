package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.middle;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/8/5 15:33
 */
public class MiddleImplTest {

    private static MiddleImpl MIDDLE = null;

    @Before
    public void before() {
        MIDDLE = new MiddleImpl();
    }

    @Test
    public void detectCycle() {
    }

    @Test
    public void swapPairs() {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        //        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        //        listNode6.next=listNode7;

        ListNode listNode = MIDDLE.swapPairs(listNode1);
        System.out.println("111");
    }

    @Test
    public void myPow() {

        double v = MIDDLE.myPow(2.10000, 3);
        System.out.println(v);
    }

    @Test
    public void search() {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int i = search1(nums,3);
        System.out.println("aa");
    }

    public int search1(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length==1){
            return nums[0] == target?0:-1;
        }
        int s = 0,e=nums.length-1;
        while (s<=e){
            int m = s+((e-s)>>1);
            if(nums[m]== target){
                return m;
            }else{
                //s-m为有序数组
                if(nums[s] <= nums[m]){
                    if(nums[s]<=target && target< nums[m]){
                        e = m-1;
                    }else{
                        //target在 m-e
                        s = m+1;
                    }
                }else {
                    //m-e为有序数组
                    if(nums[m]<target && target<=nums[e]){
                        s = m+1;
                    }else{
                        //target 在s-m
                        e = m-1;
                    }

                }
            }
        }
        return -1;
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(2);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right = root2;
        test02(root);
        System.out.println("1111");
    }
    TreeNode pre = null;
    public void test02(TreeNode root) {
        if(root == null){
            return;
        }
        test02(root.left);
        pre = root;
        System.out.println("pre " + pre.val);
        System.out.println("root " + root.val);
        test02(root.right);
    }

}