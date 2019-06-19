package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy.EasyImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetcodeApplicationTests {

    @Test
    public void contextLoads() {
        int nums[] = new int[]{2,7,11,5};
        EasyImpl easy = new EasyImpl();
        int[] ints = easy.twoSum(nums, 9);
        System.out.println("111");
    }

}
