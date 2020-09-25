package comgithub.kyrenesjtv.stepbystep.demodatadesignandarithmetic.arithmetic.sort.quickSort;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2020/9/25 17:58
 */
public class QuickSort {

    /**
     * 第一种快排
     * @param a
     * @param s
     * @param e
     */
    private void quick_sort_c(int[] a, int s, int e) {
        if(s>e){
            return;
        }
        int i = s,j=e;

        int temp = a[s];
        while(i < j){
            //s为首位的时候，先运算尾部
            while(a[j]>=temp && i < j){
                j--;
            }
            while(a[i]<=temp && i < j){
                i++;
            }

            //交换位置
            if(i < j){
                int i1 = a[i];
                a[i] = a[j];
                a[j] = i1;
            }
        }
        a[s] = a[i];
        a[i] = temp;


        quick_sort_c(a,s,j-1);
        quick_sort_c(a,j+1,e);
    }

}
