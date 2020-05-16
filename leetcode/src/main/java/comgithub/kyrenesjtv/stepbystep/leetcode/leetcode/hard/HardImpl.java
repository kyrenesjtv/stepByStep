package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.hard;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNode;

import java.time.temporal.Temporal;
import java.util.*;

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

    @Override
    public void solveSudoku(char[][] board) {

        //第一种解法：递归
        if(board == null || board.length == 0){
            return;
        }
        solveSudokuRecursion(board);
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

    private List<List<String>> result;
    private Set<Integer> cols;
    private Set<Integer> pie;
    private Set<Integer> na;

    @Override
    public List<List<String>> solveNQueens(int n) {
        //第一种解法：DFS（回溯）

        result = new ArrayList<>();
        cols = new HashSet<>();
        pie = new HashSet<>();
        na = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        dfs_solveNQueens(n,0,stack);
        return result;
    }

    private void dfs_solveNQueens(int n , int row ,Stack<Integer> stack){
        //结束条件
        if(row >= n){
            List<String> board = convert2board(stack, n);
            result.add(board);
            return;
        }

        //循环判断
        for(int i= 0 ;i<n; i++){
            //不在丨， 丿 ，丶 里面(都是常数，当一个皇后确定下来的时候)
            if(!cols.contains(i) && !pie.contains(row+i) && !na.contains(row-i)){
                System.out.printf("第 %d 行,第 %d 列 %n",row+1,i+1);
                cols.add(i);
                pie.add(row+i);
                na.add(row-i);
                stack.add(i);
                dfs_solveNQueens(n,row+1,stack);
                cols.remove(i);
                pie.remove(row+i);
                na.remove(row-i);
                stack.pop();
            }
        }
    }

    private List<String> convert2board(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }


}
