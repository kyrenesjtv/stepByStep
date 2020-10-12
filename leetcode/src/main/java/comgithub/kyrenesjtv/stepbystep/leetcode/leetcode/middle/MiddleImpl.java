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
    public List<String> generateParenthesis(int n) {
        //第一种方法：递归 有n个( 和n个)。第0位必定为( 第n-1位必定为)
        List<String> result = new ArrayList<>();
        generateParenthesis("",result,n,n);
        return result;
    }

    public void generateParenthesis(String s , List<String> result , int left , int right){
        if(left == 0 && right == 0){
            result.add(s);
            return ;
        }
        if(left > 0 ){
            generateParenthesis(s+"(",result,left-1,right);
        }
        //必须要先有( 再会有) 所以这边条件不能为right > 0
        if(right > left){
            generateParenthesis(s+")",result,left,right-1);
        }
    }

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
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0){
            return false;
        }
       return solveSudokuRecursion(board);
    }

    @Override
    public int search(int[] nums, int target) {
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

    private boolean solveSudokuRecursion(char[][] board) {
        for(int i = 0 ; i<board.length;i++){
            for(int j = 0 ; j<board[0].length;j++ ){
                //是空的
                if(board[i][j] == '.'){
                    for(char c = '1'; c<='9';c++){
                        //判断C是否能放入当前位置
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;
                            if(solveSudokuRecursion(board)){
                                return true;
                            }else {
                                // 当前的C不是正确的C
                                board[i][j] = '.';
                            }
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col,char cur) {
        for(int i = 0 ; i<9 ;i++){
            //判断y
            if(board[i][col] != '.' && board[i][col] == cur){
                return false;
            }
            //判断x
            if(board[row][i] != '.' && board[row][i] == cur){
                return false;
            }
            //判断九宫格 3*(row/3)--》 确定大坐标。 第一象限 x轴/3 ，y轴%3
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] != '.' && board[3*(row/3)+i/3][3*(col/3)+i%3] == cur){
                return false;
            }

        }
        return true;
    }
    @Override
    public double myPow(double x, int n) {

        //第一种方法：调用MATH
//        return Math.pow(x,n);

        //第二种方法：for循环
        /**double result = 1;
        //n小于0  x 变成1/x
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        for(int i = 0 ; i< n;i++){
                result *=  x;
        }
        return result;*/

        //第三种方法：while循环
        /**double result = 1;
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        while (n > 0){
            result *=  x;
            n--;
        }
        return result;*/

        //第四种方法：递归
        /**if(n < 0){
            x = 1/x;
            n = -n;
        }
        return recursionPow(x,n);*/

        //第五种方法：分治（二分递归） 采取一半的运算
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        return fastRecursionPow(x,n);



    }

    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {

        //第一种方法：BFS 广度优先搜索
        /**List<List<Integer>> result = new ArrayList<>();

        if(null==root){
            return result;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        //记录层数
        int index = 0;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            for(int i = 0;i<length;i++){
                TreeNode curr = queue.removeFirst();
                list.add(curr.val);
                if(curr.left != null){
                    queue.addLast(curr.left);
                }
                if(curr.right != null){
                    queue.addLast(curr.right);
                }
            }
            result.add(list);
            index++;
        }
        return result;*/

        //第二种方法：深度优先搜索 DFS 也就是递归
        List<List<Integer>> result = new ArrayList<>();

        if(null==root){
            return result;
        }
        dfsLevelOrder(root,0,result);
        return result;
    }

    public void dfsLevelOrder(TreeNode node , int level,List<List<Integer>> levelList){
        //防止多出尾巴
        if(level == levelList.size()){
            levelList.add(new ArrayList<>());
        }
        levelList.get(level).add(node.val);
        if(node.left!=null){
            dfsLevelOrder(node.left,level+1,levelList);
        }
        if(node.right!=null){
            dfsLevelOrder(node.right,level+1,levelList);
        }
    }

    public double fastRecursionPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double v = fastRecursionPow(x, n >>1);
        if(n % 2 == 0){
            //偶数
            return v*v;
        }
        //奇数
        return v*v*x;
    }

    public double recursionPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double v = recursionPow(x, n - 1);
        return v*x;
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
