package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/9/8 21:58
 */
public class KthLargest_List {

    private List<Integer> intList = null;

    private int length = 0;

    public KthLargest_List(int k, int[] nums) {
        intList = new ArrayList<>();
        this.length = k;
        //对nums进行排序
        insertionSort(nums , nums.length);

        for(int i = 0 ; i<nums.length ; i++){
            intList.add(nums[i]);
            //维护 list 长度为k
            if(intList.size() == k){
                return;
            }
        }
    }

    public int add(int val) {
        if(intList.size() < this.length){
            intList.add(val);
            insertionSort(intList,intList.size());
        }else{
            if(intList.get(intList.size()-1) < val ){
                intList.add(val);
                insertionSort(intList,intList.size());
                intList = intList.subList(0,this.length);
            }
        }

        return intList.get(intList.size()-1);
    }

    /**
     *  插入排序 由大到小
     * @param a 数组
     * @param n 数组长度
     */
    private static void insertionSort(int[] a , int n )  {
        if(n <= 0 ){
            return;
        }
        for(int i = 1 ; i < n ; i++){
            int value = a[i];
            int j=i-1;
            for(; j>=0;j--){
                //进行数据交换
                if(a[j] < value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            //插入数据
            a[j+1]=value;
        }
    }

    private static void insertionSort(List<Integer> a, int n )  {
        if(n <= 0 ){
            return;
        }
        for(int i = 1 ; i < n ; i++){
            int value = a.get(i);
            int j=i-1;
            for(; j>=0;j--){
                //进行数据交换
                if(a.get(j) < value){
                    a.set(j+1, a.get(j));
                }else {
                    break;
                }
            }
            //插入数据
            a.set(j+1 , value);
        }
    }

}
