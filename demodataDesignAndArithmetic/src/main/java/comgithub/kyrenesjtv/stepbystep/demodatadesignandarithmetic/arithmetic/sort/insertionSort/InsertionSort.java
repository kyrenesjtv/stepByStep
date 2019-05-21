package comgithub.kyrenesjtv.stepbystep.demodatadesignandarithmetic.arithmetic.sort.insertionSort;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/5/21 10:26
 */
public class InsertionSort {

    /**
     * 第一种插入排序
     * @param sort 数组
     * @param n 数组的大小
     */
    public void insertionSort(int[] sort , int n ){
        if(n < 1){
            return;
        }

        for(int i = 1 ; i<n;++i){
            int value = sort[i];
            int j = i-1;
            for(;j>=0;--j){
                if(sort[j] >value){
                    //数据移动
                    sort[j+1]=sort[j];
                }else {
                    break;
                }
            }
            //插入数据
            sort[j+1]=value;
        }

    }

}
