package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.middle;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNode;
import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNodeCircle;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/8/5 15:33
 */
public class MiddleImpl implements Middle{

    @Override
    public ListNode swapPairs(ListNode head) {
        //第一种解法：while
        /**if(head == null){
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode temp1 = result;
        while(head != null){
            if(head != null && head.next != null){
                ListNode next = head.next;// next 2 3 4 5
                temp1.next=next;//temp1 2 3 4 5
                head.next = head.next.next;// 1 3 4 5
                next.next =head;// next 2 1 3 4 5
                head = head.next;// head 3 4 5
                temp1 = temp1.next.next;// temp1 3 4 5
            }else {
                temp1.next = head;
                head = head.next;
            }
        }
        return result.next;*/

        //第二种解法：递归
        if(head == null ||head.next == null){
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;
        return temp;
    }

    @Override
    public ListNodeCircle detectCycle(ListNodeCircle head) {

        //第一种解法：hashSet
        /**if(head == null || head.next == null){
            return null;
        }
        Set<ListNodeCircle> set = new HashSet<>();

        while(head != null){
            //如果存在 return node
            if(!set.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;*/

        //第二种解法：快慢指针

        //数学换算 ： 假设有环的情况下， head 到 enter (进入环的node) 为 F 。 enter 到 meet (两个node 相遇的node ) 为 A  meet 到 enter 为 B

        /**
         * 情况1 ： 慢指针走了 F + A 的长度 ； 快指针 走了 F + A + B + A 后两者相遇了。 可得 F + A = F + A + B + A 。 即 F = B 。 那么F长度的node就是进入环的node
         *
         * 情况2： 慢指针走了 F + A 的长度 ； 快指针 走了 F + n( A + B) + A 后两者相遇了。 可得 F + A = F + n(A + B )+ A 。 即 F = (n-1)(A+B) + B 。
         *         快指针多走了N遍的环 ，那么F长度的node依旧是进入环的node
         *
         */

        if(head == null || head.next == null){
            return null;
        }
        //首先确立 meet 点
        ListNodeCircle slow = head;
        ListNodeCircle fast = head;
        ListNodeCircle meet = null;

        while(slow != null && fast.next != null){
            if(slow == fast){
                //相遇点
                meet = slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        //接下来 就是first 与 meet互相走F步 就是 enter 的 node
        ListNodeCircle first = head;
        ListNodeCircle enter = null;
        while(first != meet){
            first = first.next;
            meet = meet.next;
        }

        return enter;
    }


}
