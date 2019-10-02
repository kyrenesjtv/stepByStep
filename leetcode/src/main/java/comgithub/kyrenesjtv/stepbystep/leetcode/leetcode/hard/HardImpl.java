package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.hard;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNode;

import java.time.temporal.Temporal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/8/5 15:28
 */
public class HardImpl implements Hard {

    @Override
    public ListNode reverseKGroup(ListNode head, int k) {

        //第一种方法：栈
        /**if(head == null){
         return null;
         }
         Stack<ListNode> que = new Stack<ListNode>();
         //头指针
         ListNode result = new ListNode(0);
         //当前指针
         ListNode temp = result;
         while(true){
         //当前指针
         ListNode temp2 = head;
         int count = 0;
         while(temp2 != null && count <k){
         //添加
         que.push(temp2);
         temp2=temp2.next;
         count++;
         }
         //判断count的值 ==k 为有K个， !=k 为不足K个
         if(count != k){
         //顺序添加
         temp.next=head;
         break;
         }
         while(!que.isEmpty()){
         //倒序添加
         temp.next=que.pop();
         temp=temp.next;
         }
         //赋值
         head=temp2;
         temp.next=temp2;
         }
         return result.next;*/


        //第二种方法：尾插法
        /**if(head == null){
         return null;
         }
         ListNode result = new ListNode(0);
         result.next = head;
         //头指针
         ListNode head1 = result;
         //尾指针
         ListNode tail1 = result;

         while(true){
         int count = 0 ;
         while(tail1 != null &&count<k){
         tail1=tail1.next;
         count++;
         }
         //小于K了， 那么tail1 也就是为null。剩余的数据也不用进行位置交换
         if(tail1 == null){
         break;
         }
         ListNode temp = head1.next;
         //进行位置交换 , 依次把curr 移到tail1 后面
         while(head1.next != tail1){
         ListNode curr = head1.next;
         head1.next=curr.next;
         curr.next = tail1.next;
         tail1.next=curr;
         }
         head1=temp;
         tail1=temp;
         }
         return result.next;*/


        //第三种方法：递归
        if (head == null) {
            return null;
        }
        ListNode result = head;
        int count = 0;
        while (result != null && count != k) {
            result = result.next;
            count++;
        }

        if (count == k) {
            result = reverseKGroup(result, k);
            //数据交换
            while (count != 0) {
                ListNode temp = head.next;
                head.next = result;
                result = head;
                head = temp;
                count--;
            }
            head = result;
        }
        return head;

    }


}
