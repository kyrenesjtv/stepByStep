package comgithub.kyrenesjtv.stepbystep.demodatadesignandarithmetic.arithmetic.sort.bubbleSort;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/5/21 10:11
 */
public class BubbleSort {


    /**
     * 第一种冒泡排序
     *
     * @param sort 数组
     * @param n    数组的大小
     */
    public void bubbleSort(int[] sort, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            //提前退出冒泡排序的标志位
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (sort[j] > sort[j + 1]) {
                    int temp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp;
                    //有数据进行交换
                    flag = true;
                }
            }
            if (!flag) {
                //提前退出，执行下一次循环
                break;
            }
        }

    }


}
