package com.github.kyrenesjtv.stepbystep.java4error100;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
class Java4error100ApplicationTests {

    @Test
    void contextLoads() {
        Stream<String> stringStream = IntStream.range(1, 10000).mapToObj(__ -> "a");
        String collect = IntStream.range(1, 10000).mapToObj(__ -> "a").collect(Collectors.joining(""));
        List<String> collect1 = IntStream.range(1, 10000).mapToObj(__ -> "a" + __).collect(Collectors.toList());
        System.out.println("123");
    }

}
