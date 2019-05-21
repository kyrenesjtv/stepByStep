package comgithub.kyrenesjtv.stepbystep.demodatadesignandarithmetic.dataStructure.string.kpm;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/3/17 20:24
 */
public class KMP {

    /**
     * KMP 朴素算法， next具体的值要从下标1开始看
     * @param target
     */
    public static int[] getNext(String target ){
        int i = 0;
        int j = -1;
         int[] next = new int[target.length()];
        next[0] = j;
        //转数组
        char[] chars = target.toCharArray();

        while(i <target.length()-1){
            //不相等回溯，相等+1
            if(j == -1 || chars[i] == chars[j]){
                ++i;
                ++j;
                //赋予K值
                next[i]=j;
            }else {
                //数据回溯 K值
                j=next[j];
            }
        }
        return next;
    }

    /**
     * KMP 改良算法， next具体的值要从下标1开始看
     * @param target
     */
    public static int[] getNextval(String target ){
        int i = 0;
        int j = -1;
        int[] next = new int[target.length()];
        next[0] = j;
        //转数组
        char[] chars = target.toCharArray();

        while(i <target.length()-1){
            //不相等回溯，相等+1
            if(j == -1 || chars[i] == chars[j]){
                ++i;
                ++j;
                if(chars[i] != chars[j]){
                    //不相等为原来朴素算法的K值
                    next[i]=j;
                }else {
                    //相等的话，为J索引的K值
                    chars[i] = chars[j];
                }
            }else {
                //数据回溯 K值
                j=next[j];
            }
        }
        return next;
    }

    /**
     * 判断字符串是否包含,包含返回其实的下标位置， 不包含返回-1
     * @param source
     * @param target
     */
    public static int indexOf(String source , String target){
        int i = 0 ;
        int j = 0 ;

        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();

        int sourceLength = source.length();
        int targetLength = target.length();

        int[] nextval = getNextval(target);

        while(i<sourceLength && j<targetLength){

            if( j == 0 || sourceChars[i] == targetChars[j]){
                //相等，继续匹配后一个字符
                ++i;
                ++j;
            }else {
                //不匹配， 则target向右移动位
                j = nextval[j];
            }
        }
        if(j == targetLength){
            return i - targetLength;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
//        int[] qweqweqwes = getNextval("qweqweqwe");
//        System.out.println(qweqweqwes.toString());
                int i = indexOf("asdqwezxc", "qwe");
        System.out.println("111");
    }

}
