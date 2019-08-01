package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/6/19 16:55
 */
public class EasyImpl implements Easy {

    @Override
    public int[] twoSum(int[] nums, int target) {


        if(nums.length<2){
            return null;
        }

        //第一种解法：冒泡  时间复杂度 O(n*n) , 空间复杂度 O(1)
        /**for(int i = 0 ; i<nums.length-1 ; i++){
            for(int j = i+1 ; j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                   return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");*/

        //第二种解法：hash 。 通过第二个索引去找第一个。 时间复杂度O(n), 空间复杂度0(1);
        Map<Integer, Integer> paramMap = new HashMap<>();
        for(int i = 0 ; i<nums.length ; i++){
            paramMap.put(nums[i],i);
            if(paramMap.containsKey(target - nums[i])){
                return new int[]{paramMap.get(target - nums[i]),i};
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    @Override
    public int reverse(int x) {

        //第一种方法：利用字符串的翻转来做
        /**Boolean isNegative = false;
        //判断是否是负数
        if(x < 0 ){
            x=0-x;
            isNegative = true;
        }
        StringBuilder reverse = new StringBuilder(String.valueOf(x)).reverse();

        int i = Integer.parseInt(reverse.toString());
        if(isNegative){
            i=0-i;
            if(i < Integer.MIN_VALUE){
                return 0;
            }

        }else {
            if( i > Integer.MAX_VALUE){
                return 0 ;
            }
        }
        return i;*/

        //第二种方案 通过取余的方式
        int temp = 0;
        while(x!=0){
            int remove = x%10;
            x = x/10;
            //最后一次的时候  MAX_VALUE = 2147483647  MIN_VALUE = -2147483648
            if((temp > Integer.MAX_VALUE/10)||(temp == Integer.MAX_VALUE/10 && remove == 7)){
                return 0;
            }
            if((temp < Integer.MIN_VALUE/10)||(temp == Integer.MIN_VALUE/10 && remove == -8)){
                return 0;
            }
            temp = temp * 10 + remove;
        }

        return temp;
    }

    @Override
    public boolean isPalindrome(int x) {

        //第一种：利用string的反转
        /**
         if(x < 0 ){
            return false;
         }
         if(String.valueOf(x).equals(new StringBuilder(String.valueOf(x)).reverse().toString())){
            return true;
        }else {
            return false;
        }*/

        //第二种：利用取余
        if(x < 0 ){
            return false;
        }
        if(x == 0 || x/2 == 0){
            return true;
        }
        int temp = 0;
        while(x != 0 ){
            int temp1 = x%10;
            temp = temp*10 + temp1;
            x=x/10;
            if(x == temp || x == temp/10){
                return true;
            }
        }
        return false;
    }

    @Override
    public int romanToInt(String s) {

        //第一种： 遍历  右边的比左边的小为减，反之为加
        Map<Character, Integer> paramMap = new HashMap<>();
        paramMap.put('I',1);
        paramMap.put('V',5);
        paramMap.put('X',10);
        paramMap.put('L',50);
        paramMap.put('C',100);
        paramMap.put('D',500);
        paramMap.put('M',1000);
        char[] chars = s.toCharArray();
        Integer preInt = 0;
        Integer currInt = 0;
        Integer total = 0;
        //判断上一次是否是相减的 true 相减 false 相加
        Boolean temp = false;
        for(int i = chars.length-1 ; i>=0 ; i--){
            //转成String
            Character key = chars[i];
            currInt = paramMap.get(key);
            if(currInt>preInt || ( currInt==preInt && temp==false)){
                total += paramMap.get(key);
            }else if(currInt<preInt ||( currInt==preInt && temp==true) ){
                total -= paramMap.get(key);
                temp=true;
            }
            preInt = paramMap.get(key);
        }
        return total;
    }

    @Override
    public String longestCommonPrefix(String[] strs) {

        //第一种：横向循环，直接取出索引0的str
        /**if(strs.length == 0){
            return "";
        }
        String temp = strs[0];
        for(int i = 1; i<strs.length;i++){
            while(strs[i].indexOf(temp) != 0 ){
                temp = temp.substring(0,temp.length()-1);
            }
            //有随机两个不匹配就全部不匹配
            if(temp.isEmpty()){
                return "";
            }
        }
        return temp;*/

        //第二种：横向循环， 取出长度最短的str
        /**if(strs.length == 0){
            return "";
        }
        String temp = strs[0];
        for(int i = 1; i<strs.length;i++){
            if(strs[i].length()<temp.length()){
                temp = strs[i];
            }
        }
        for(int i = 1; i<strs.length;i++){
            while(strs[i].indexOf(temp) != 0 ){
                temp = temp.substring(0,temp.length()-1);
            }
            //有随机两个不匹配就全部不匹配
            if(temp.isEmpty()){
                return "";
            }
        }
        return temp;*/

        //第三种：比较同一索引的字符
        /**if(strs.length == 0){
            return "";
        }
        for(int i =0 ; i < strs[0].length();i++){
            char c  = strs[0].charAt(i);
            for(int j = 1 ; j<strs.length;j++){
                //判断strs[j]的长度
                if(strs[j].length() == i ||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        //这个return 是strs[0]是最短的
        return strs[0];*/

        //第四种：分治
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }

        return longestCommonPrefix(strs,0,strs.length-1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if(l==r){
            return strs[l];
        }else {
            int mid = (l+r)/2;
            String leftString = longestCommonPrefix(strs,l,mid);
            String rightString = longestCommonPrefix(strs,mid+1,r);
            return compareString(leftString,rightString);
        }

    }
    private String compareString(String leftString, String rightString) {
        int min = Math.min(leftString.length(),rightString.length());

        for(int i = 0 ; i<min;i++){
            if(leftString.charAt(i) != rightString.charAt(i)){
                return leftString.substring(0,i);
            }
        }
        return leftString.substring(0,min);
    }


    @Override
    public boolean isValid(String s) {

        //第一种：利用栈
        if(s.equals("")){
            return true;
        }
        //组装一个map 反的是用来取值， 这样子就能不能判断stack最新的一个是否是对应的括号
        Map<Character, Character> paramMap = new HashMap<>();
        paramMap.put(')','(');
        paramMap.put(']','[');
        paramMap.put('}','{');

        Stack<Character> paramStack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //这样子就能判断stack里面是否有对应的括号 ( [ {
            if(paramMap.containsKey(c)){
                //去stack里面 拿出最上面一个数据
                if(paramStack.isEmpty()){
                    return false;
                }else {
                    Character pop = paramStack.pop();
                    if(pop!=paramMap.get(c)){
                        return false;
                    }
                }
            }else {
                paramStack.add(c);
            }
        }
        //全部循环完毕了， 为空就是符合规则的字符串
        return paramStack.empty();
    }


    @Override
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //第一种方法：while
       if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head = new ListNode(Integer.MAX_VALUE);
        //防止head被替换
        ListNode pre=head;
        while(l1 != null && l2 != null){
            if(l1.val<=l2.val){
                pre.next=l1;
                l1=l1.next;
            }else {
                pre.next=l2;
                l2=l2.next;
            }
            pre=pre.next;
        }
        pre.next=l1==null?l2:l1;
        return head.next;
    }

    @Override
    public int removeDuplicates(int[] nums) {

        //第一种方法：两个指针前后互相比较
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        //返回的长度，如果有数据交换就 ++
        int k =1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    @Override
    public int removeElement(int[] nums, int val) {
        //第一种：循环,k从0开始
        /**if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        //返回的长度
        int k = 0;
        for(int i = 0 ; i<nums.length;i++){
            //当数据不相等话，k就发生变化
            if(nums[i]!=val){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;*/

        //第而种：k从nums.length开始
        if(nums.length==0){
         return 0;
         }
         if(nums.length==1){
         return 1;
         }
         //返回的长度
         int k = nums.length;
         int i = 0 ;
         while(i<k){
             if(nums[i]==val){
                 //进行数据交换，并再次检查当前索引位置的值
                 nums[i] = nums[k-1];
                 k--;
             }else {
                 i++;
             }
         }
         return k;
    }


}
