package comgithub.kyrenesjtv.stepbystep.demodatadesignandarithmetic.arithmetic.sort.selectionSort;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/5/22 14:29
 */
public class SelectionSort {

    /**
     * 第一种选择排序
     * @param sort
     * @param n
     */
    public  void SelectionSort(int[] sort ,int n){
        if(n<1){
            return;
        }

        for(int i = 0 ; i<n-1 ; i++){
            int k = i ;
            for(int j = i+1;j<n;j++){
                if(sort[j]<sort[i]){
                    //索引交换
                    k=j;
                }
            }
            if(i != k ){
                //数据交换
                int temp = sort[k];
                sort[k]=sort[i];
                sort[i]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] sort = new int[]{4,5,6,3,2,1};
        SelectionSort(sort,6);
        System.out.println("1111");
    }

}
