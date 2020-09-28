package comgithub.kyrenesjtv.stepbystep.demodatadesignandarithmetic.arithmetic.sort.bucketSort;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2020/9/28 18:13
 */
public class BucketSort {

    /**
     * 桶排序
     * @param a
     */
    private void bucketSort(int[] a) {
        ArrayList<LinkedList<Integer>> linkedLists = new ArrayList<>();
        //创建10个桶
        for(int i = 0 ; i<10 ; i++){
            linkedLists.add(new LinkedList<Integer>());
        }
        for(int i = 0 ; i < a.length; i++){
            //判断放入位置
            int result = getIndex(a[i]);
            //插入排序
            insertSort(linkedLists.get(result),a[i]);
        }
        //塞数据
        int index = 0;
        for(LinkedList<Integer> ll : linkedLists){
            for(Integer va : ll){
                a[index++] = va;
            }
        }
    }

    private void insertSort(LinkedList<Integer> integers, int num) {
        //这边应该可以优化，优化的内容要根据实际入参数组来决定
        integers.add(num);
        if(integers.size() >1 ){
            for(int i = 1 ; i<integers.size();i++){
                int value = integers.get(i);
                int j = i-1;
                for(;j>0;j--){
                    if(integers.get(i) < integers.get(j)){
                        integers.set(j+1,integers.get(j));
                    }else {
                        break;
                    }
                }
                integers.set(j,value);
            }
        }
    }

    private int getIndex(int i) {
        return i%10;
    }


}
