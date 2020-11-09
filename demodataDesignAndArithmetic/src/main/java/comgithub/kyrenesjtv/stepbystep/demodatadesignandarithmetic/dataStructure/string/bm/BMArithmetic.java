package comgithub.kyrenesjtv.stepbystep.demodatadesignandarithmetic.dataStructure.string.bm;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2020/11/9 16:42
 */
public class BMArithmetic {

    private static final int SIZE = 256; // 全局变量或成员变量


    /**
     * 初始化模式串，这样子能快速找到模式串中坏字符的最大索引位
     * @param b 模式串
     * @param m 模式串的长度
     * @param bc 模式串字符ASCII 对应的最大索引位置
     */
    private void generateBC(char[] b, int m, int[] bc) {
        for(int i = 0 ; i<SIZE ; i++){
            bc[i] = -1;
        }
        for(int i = 0 ; i<m ; i++){
            int ascii = b[i];
            bc[ascii] = i;
        }
    }


    /**
     * 坏字符规则
     * BM算法的坏字符规则
     * @param a 主串
     * @param n 主串的长度
     * @param b 模式串
     * @param m 模式串的长度
     * @return
     */
    public int bm_bad(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE];
        generateBC(b,m,bc);
        int i = 0 ;
        while(i <= m-n){
            int j  ;
            //模式串从后往前匹配
            for( j = m-1; j>=0 ;j--){
                if(a[i+j] != b[j]){
                    //出现了坏字符
                    break;
                }
            }
            if(j < 0  ){
                //匹配成功，返回i
                return i;
            }
            //没匹配成功，移动位置 , (int)b[j] 为坏字符，bc[(int)b[j]] 为坏字符在模式串中索引最大的
            i = i + (j - bc[(int)b[j]]);
        }
        return -1;
    }


    /**
     * 好后缀规则
     * 计算模式串的后缀字符串跟模式串的前缀字符串是否有吻合的
     * @param b 模式串
     * @param m 模式串的长度
     * @param suffix 索引代表后缀字符串的长度，值表示前缀字符串在模式串的下标起始位(如果有吻合的话)
     * @param prefix suffix的下标是否是从0开始的，是的话就为true，否则为false。
     */
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        //初始化
        for(int i = 0 ; i< m ; i++){
            suffix[i] = -1;
            prefix[i] = false;
        }
        for(int i = 0 ; i< m-1 ; i++){
            int j = i;
            int k = 0;//后缀字符串的长度
            while(j >= 0 && b[j] == b[m-1-k]){
                --j;
                ++k;
                suffix[k] = j+1;//后缀字符串对应的前缀字符串的索引起始位置
            }
            if(j == -1){
                //是后缀字符串也是前缀字符串
                prefix[k] = true;
            }
        }
    }

    /**
     * 坏字符规则和好后缀规则一起计算，取较大值
     * @param a 主串
     * @param n 主串的长度
     * @param b 模式串
     * @param m 模式串的长度
     * @return
     */
    public int bm_bad_good(char[] a, int n, char[] b, int m){
        //坏字符
        int[] bc = new int[SIZE];
        generateBC(b,m,bc);
        //好后缀
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b,m,suffix,prefix);
        int i = 0 ;
        while(i <= m-n){
            int j  ;
            //模式串从后往前匹配
            for( j = m-1; j>=0 ;j--){
                if(a[i+j] != b[j]){
                    //出现了坏字符
                    break;
                }
            }
            if(j < 0  ){
                //匹配成功，返回i
                return i;
            }
            int x = j - bc[(int) b[j]];
            int y = 0 ;
            if(y< m-1 ){
                moveByGS(j,m,suffix,prefix);
            }
            i = i + Math.max(x,y);
        }
        return -1;
    }

    /**
     * 计算好后缀该移动几位
     * @param j j标识当前坏字符在模式串中的索引位置
     * @param m 模式串的长度
     * @param suffix
     * @param prefix
     * @return
     */
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m -j -1; // 好后缀的长度
        if(suffix[k] != -1){
            return j - suffix[k] -1;
        }
        //避免过多移动,为什么要加2？ 因为+1话就是只有一个字母（这样就跟坏字符一样），+2就是2个单词起步
        for(int i = j+2 ; i < m ;i++ ){
            if(prefix[m-i] == true){
                return i;
            }
        }
        return m;
    }


}
