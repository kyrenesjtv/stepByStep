package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

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




}
