package comgithub.kyrenesjtv.stepbystep.demodatadesignandarithmetic.arithmetic.sort.radixSort;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2020/9/29 19:40
 */
public class RadixSort {
    /**
     *
     * @param a
     * @param max 数据最大的是几位数
     */
    private void radixSort(int[] a, int max) {
        int length = a.length;
        int[] temp = new int[length];
        int[] bucket = new int[length];

        //判断位数
        for(int i = 1 ; i<= max; i++){
            //清空
            for(int j = 0 ; j< length ; j++){
                temp[j] = 0;
            }
            //判断位数上之前别分有几个(以下类似于计数排序)
            for(int j = 0 ; j <length ; j++){
                temp[getFigure(a[j],i)]++;
            }
            for(int j = 1 ; j <length;j++){
                temp[j] = temp[j]+temp[j-1];
            }
            for(int j = length-1 ; j>=0;j--){
                bucket[temp[getFigure(a[j],i)]-1] = a[j];
                temp[getFigure(a[j],i)]--;
            }
            //赋值
            for(int j = 0 ; j< length ; j++){
                a[j] = bucket[j];
            }
        }

    }

    private int getFigure(int i, int k) {
        return (i/new Double(Math.pow(10, k - 1)).intValue())%10;
    }


}
