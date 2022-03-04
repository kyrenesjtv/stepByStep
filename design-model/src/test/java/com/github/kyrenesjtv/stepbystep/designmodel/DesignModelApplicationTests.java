package com.github.kyrenesjtv.stepbystep.designmodel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DesignModelApplicationTests {

    @Test
    void contextLoads() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        Integer integer = integers.stream().max((o1, o2) -> o1 > o2 ? 1 : -1).orElse(0);
        System.out.println(integer);
    }

}
