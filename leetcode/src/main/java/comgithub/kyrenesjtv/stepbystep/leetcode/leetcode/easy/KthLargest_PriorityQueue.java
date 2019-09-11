package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

import java.util.PriorityQueue;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/9/8 21:58
 */
public class KthLargest_PriorityQueue {

    private PriorityQueue<Integer> intList = null;

    private int length = 0;

    public KthLargest_PriorityQueue(int k, int[] nums) {
        intList = new PriorityQueue<>(k);
        this.length = k;
        for(int i = 0 ; i<nums.length ; i++){
            intList.offer(nums[i]);
            if(intList.size() > k){
                intList.poll();
            }
        }
    }

    public int add(int val) {
        if(intList.size() < this.length){
            intList.offer(val);
        }else if(val > intList.peek()){
            intList.poll();
            intList.offer(val);
        }
        return intList.peek();
    }

}
