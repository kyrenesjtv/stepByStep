package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.middle;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNode;
import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNodeCircle;

import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/8/5 15:33
 */
public class MiddleImpl implements Middle {

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
        if (head == null || head.next == null) {
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

        if (head == null || head.next == null) {
            return null;
        }
        //首先确立 meet 点
        ListNodeCircle slow = head;
        ListNodeCircle fast = head;
        ListNodeCircle meet = null;

        while (slow != null && fast.next != null) {
            if (slow == fast) {
                //相遇点
                meet = slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        //接下来 就是first 与 meet互相走F步 就是 enter 的 node
        ListNodeCircle first = head;
        ListNodeCircle enter = null;
        while (first != meet) {
            first = first.next;
            meet = meet.next;
        }

        return enter;
    }


    private TreeNode pre = null;

    @Override
    public boolean isValidBST(TreeNode root) {
        //第一种方法：递归 判断左边的值是否都是小于root  右边的值是否都是大于root
        /**return isValidBSTHelper(root,null,null);*/

        //第二种方法：递归 代码简化
//        return isValidBSTHelper1(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

        //第三种方法：中序遍历 左根右
        /**if(root == null){
            return true;
        }
        //遍历到最左边的一个节点 该节点的左节点为null
        if(!isValidBST(root.left)){
            return false;
        }
        //进行判断
        if(pre != null && root.val <= pre.val ){
            return false;
        }
        //保存子节点的信息
        pre = root;
        return isValidBST(root.right);*/

        //第四种方法：迭代 中序遍历
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode temp = root;
        TreeNode pre1 = null;

        while(temp != null && !nodeStack.isEmpty()){
            //最左下角
            while(temp != null){
                nodeStack.push(temp);
                temp = temp.left;
            }
            temp = nodeStack.pop();
            //进行对比，在最左下角的时候temp是为null的
            if(pre1 != null && pre1.val >= temp.val){
                return false;
            }
            //记住上一次
            pre1 = temp;
            temp = temp.right;
        }

        return true;
    }

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //第一种方法： 递归 去找p 和 q
        /**if(root == null || root == p || root ==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        return left == null? right: right==null?left:root;*/

        //第二种方法：迭代
        if(root == null || root == p || root ==q){
            return root;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Map<TreeNode, TreeNode> nodeHashMap = new HashMap<>();
        nodeHashMap.put(root,null);
        nodeStack.push(root);
        while(!nodeHashMap.containsKey(p) ||!nodeHashMap.containsKey(q) ){
            TreeNode parent = nodeStack.pop();
            if(root.left != null){
                nodeHashMap.put(root.left,parent);
                nodeStack.push(root.left);
            }
            if(root.right != null){
                nodeHashMap.put(root.right,parent);
                nodeStack.push(root.right);
            }
        }
        // 用来存放p的这一系祖先
        Set<TreeNode> nodeSet = new HashSet<>();
        while(p != null){
            nodeSet.add(p);
            p = nodeHashMap.get(p);
        }
        //查看 q 的祖先与 p的交点
        while(!nodeSet.contains(q)){
            q = nodeHashMap.get(q);
        }
        return q;
    }



    private boolean isValidBSTHelper1(TreeNode node, Integer left, Integer right) {
        if(node == null){
            return true;
        }
        Integer val = node.val;
        if(val <= left || val>= right){
            return false;
        }
        return isValidBSTHelper1(node.left,left,val)&&isValidBSTHelper1(node.right,val,right);
    }

    private Boolean isValidBSTHelper(TreeNode node , Integer left , Integer right){
        if(node == null){
            return true;
        }
        Integer val = node.val;
        if(left != null && val <= left){
            return false;
        }
        if(right != null && val >= right){
            return false;
        }
        //左边的要与右上方进行比较
        if(!isValidBSTHelper(node.left,left,val)){
            return false;
        }
        //右边的要与左上方进行比较
        if(!isValidBSTHelper(node.left,val,right)){
            return false;
        }
        return true;
    }

}
