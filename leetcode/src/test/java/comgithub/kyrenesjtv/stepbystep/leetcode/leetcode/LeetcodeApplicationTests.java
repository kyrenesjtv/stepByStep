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

        EasyImpl easy = new EasyImpl();
        boolean palindrome = easy.isPalindrome(123321);
        System.out.println("11");

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

}
