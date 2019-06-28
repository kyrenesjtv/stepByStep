package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

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


}
