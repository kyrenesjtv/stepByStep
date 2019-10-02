package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy.EasyImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetcodeApplicationTests {

    @Test
    public void contextLoads() {
        //        int nums[] = new int[]{2,7,11,5};
        //        EasyImpl easy = new EasyImpl();
        //        int[] ints = easy.twoSum(nums, 9);
        //        System.out.println("111");

        //        EasyImpl easy = new EasyImpl();
        //        int reverse = easy.reverse(-1230);
        //        System.out.println("111");

        //        int aa = 1234 %10;
        //        System.out.println(aa);

        //        EasyImpl easy = new EasyImpl();
        //        boolean palindrome = easy.isPalindrome(123321);
        //        System.out.println("11");

        //        List<Map<String, Object>> list = new ArrayList<>();
        //
        //        Map<String, Object> map1 = new HashMap<>();
        //        map1.put("1","1");
        //        Map<String, Object> map2 = new HashMap<>();
        //        map2.put("2","2");
        //        Map<String, Object> map3 = new HashMap<>();
        //        map3.put("3","3");
        //        Map<String, Object> map4 = new HashMap<>();
        //        map4.put("4","4");
        //        list.add(map1);
        //        list.add(map2);
        //        list.add(map3);
        //        list.add(map4);
        //
        //        List<Map<String, Object>> list2 = new ArrayList<>();
        //        list2.addAll(list);
        ////        List<Map<String, Object>> list2 = list.subList(0, list.size());
        //        for(int i = 0 ,j=0; i<list.size();i++){
        //            Map<String, Object> paramMap = list.get(i);
        //            if(paramMap.containsKey("1")){
        //                Map<String, Object> tempMap = list.get(list.size() - i-1);
        //                if(j==0){
        //                    list2.set(list.size()-1,paramMap);
        //                }else {
        //                    list2.set(list.size()-1-j,paramMap);
        //                }
        //                j++;
        //            }else {
        //                list2.set(i-j,paramMap);
        //            }
        //        }
        //
        //        System.out.println("111");
        //

    }

    @Test
    public void test01() {

        List<Map<String, Object>> paramList1 = new ArrayList<>();

        List<Map<String, Object>> paramList2 = new ArrayList<>();

        List<Map<String, Object>> paramList3 = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("text", "雪亮工程社会治安综合治理信息平台");
        map1.put("children", paramList2);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("text", "通用字典");
        map2.put("children", paramList3);
        paramList2.add(map2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("text", "男");
        paramList3.add(map3);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("text", "女");
        paramList3.add(map4);

        recursionTree(map1);

        System.out.println("1111");

    }

    public static void recursionTree(Map<String, Object> map) {
        if (!map.containsKey("children")) {
            map.put("icon", "jstree-file");
        } else {
            List<Map<String, Object>> children = (List<Map<String, Object>>) map.get("children");
            for (int i = 0; i < children.size(); i++) {
                recursionTree(children.get(i));
            }
        }

    }

    @Test
    public void romanToInt() {
        EasyImpl easy = new EasyImpl();
        int iii = easy.romanToInt("MCMXCIV");
        System.out.println("111");
    }

    @Test
    public void longestCommonPrefix() {
        String aa = "qwertyui";
        String bb = "qwert";
        String cc = "dsds";
        //        while (bb.indexOf(aa) != 0) {
        //            aa = aa.substring(0, aa.length() - 1);
        //        }
        System.out.println(bb.indexOf(aa));//-1
        System.out.println(aa.indexOf(bb));//0 aa里面有bb的 , 并且从索引0开始
        System.out.println(cc.indexOf(bb));//-1

        EasyImpl easy = new EasyImpl();
        String s = easy.longestCommonPrefix(new String[]{"qwertyu", "qwe", "qwer"});
        System.out.println(s);

    }


}
