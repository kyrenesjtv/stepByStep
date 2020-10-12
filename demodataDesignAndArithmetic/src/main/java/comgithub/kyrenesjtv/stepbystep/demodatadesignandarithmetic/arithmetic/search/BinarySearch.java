package comgithub.kyrenesjtv.stepbystep.demodatadesignandarithmetic.arithmetic.search;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2020/10/11 14:23
 */
public class BinarySearch {

    /**
     * 数组中有目标值的话，返回数组下标，没有的话返回-1
     * @param a 数组
     * @param length 数据长度
     * @param i 目标值
     * @return
     */
    private int binarySearch1(int[] a, int length, int i) {
        int s = 0;
        int e = length-1;
        while (s<=e) {
            int m = (s+e)/2;
            if(a[m] == i){
                return m;
            }else if(a[m] < i){
                s = m + 1;
            }else{
                e = m -1;
            }
        }
        return -1;
    }

    /**
     * 数组中有目标值的话，返回数组下标，没有的话返回-1
     * @param a 数组
     * @param s 开始
     * @param e 结尾
     * @param i 目标值
     * @return
     */
    private int binarySearch1(int[] a,int s, int e, int i) {
        if(s>e){
            return -1;
        }
        int m = (s+e)>>1;//位运算速度更快
        if(a[m] == i){
            return m;
        }else if(a[m] < i){
            return binarySearch1(a,m+1,e,i);
        }else{
            return binarySearch1(a,s,m-1,i);
        }
    }


    /**
     * 查找第一个值等于给定值的元素
     * @param a 数组
     * @param length 数组长度
     * @param i 定值
     * @return
     */
    private int binarySearch2(int[] a, int length, int i) {
        int s = 0;
        int e = length-1;
        while(s<=e){
            int m = s + ((e - s) >> 1);
            if(a[m] > i){
                e = m-1;
            }else if(a[m] < i){
                s = m+1;
            }else{
                //如果m的前一个值不是i，就证明m是数组中的第一个定值
                if(m==0 || a[m-1] != i){
                    return m;
                }else{
                    e=m-1;
                }
            }
        }
        return -1;
    }


    /**
     * 查找最后一个值等于给定值的元素
     * @param a 数组
     * @param length 数组长度
     * @param i 定值
     * @return
     */
    private int binarySearch3(int[] a, int length, int i) {
        int s = 0;
        int e = length-1;
        while(s<=e){
            int m = s + ((e - s) >> 1);
            if(a[m] > i){
                e = m-1;
            }else if(a[m] < i){
                s = m+1;
            }else{
                //如果m的后一个值不是i，就证明m是数组中的第一个定值
                if(m==length-1 || a[m+1] != i){
                    return m;
                }else{
                    s=m+1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个值大于等于给定值的元素
     * @param a 数组
     * @param length 数组长度
     * @param i 定值
     * @return
     */
    private int binarySearch4(int[] a, int length, int i) {
        int s = 0;
        int e = length-1;
        while(s<=e){
            int m = s + ((e - s) >> 1);
            if(a[m] >= i){
                if(m == 0 || a[m-1] < i){
                    return m;
                }else{
                    e = m-1;
                }
            }else{
                s = m+1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值小于等于给定值的元素
     * @param a 数组
     * @param length 数组长度
     * @param i 定值
     * @return
     */
    private int binarySearch5(int[] a, int length, int i) {
        int s = 0;
        int e = length-1;
        while(s<=e){
            int m = s + ((e - s) >> 1);
            if(a[m] > i){
                e = m-1;
            }else{
                if(m == length-1 || a[m+1] > i){
                    return m;
                }else {
                    s = m+1;
                }
            }
        }
        return -1;
    }






}
