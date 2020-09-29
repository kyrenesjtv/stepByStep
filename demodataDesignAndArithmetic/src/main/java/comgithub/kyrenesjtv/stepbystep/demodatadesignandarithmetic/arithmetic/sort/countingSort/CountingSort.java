package comgithub.kyrenesjtv.stepbystep.demodatadesignandarithmetic.arithmetic.sort.countingSort;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2020/9/29 10:05
 */
public class CountingSort {

    private void countingSort(int[] a, int length) {
        if(length < 1){
            return;
        }
        //判断最大的数据,这个max根据实际业务可以进行固定
        int max = a[0];
        for(int i = 1 ; i<length ; i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        //申请一个数组
        int[] b = new int[max+1];
        //计算个数
        for(int i = 0 ; i< length ; i++){
            b[a[i]]++;
        }
        //计算每个位置前面有多少个数据
        for(int i=1 ; i<= max ; i++){
            b[i] = b[i] + b[i-1];
        }
        int[] c = new int[length];
        //这样子倒着来的话，就是稳定的排序，相同数字前后位置没有发生变化
        for(int i = length-1 ; i>=0; i--){
            //减1是下标从0开始，而个数是从1开始
            c[b[a[i]]-1] = a[i];
            b[a[i]]--;
        }
        //赋值
        for(int i = 0; i<length; i++){
            a[i] = c[i];
        }

    }
}
