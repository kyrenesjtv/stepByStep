package com.github.kyrenesjtv.stepbystep.java4error100.code.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

/**
 * @author huojianxiong
 * @Description 关于多个实例访问静态资源的方法
 * @Date 2021/12/29 14:02
 */
@RequestMapping("/lockdemo02")
@RestController
@Slf4j
public class LockDemo {


    //错误方法:原因是每一个线程进去查的时候，其他线程都还没有进行concurrentHashMap的数量更改操作，所以出现了超额的情况
    @GetMapping("wrong01")
    public int wrong01(@RequestParam(value = "count", defaultValue = "1000000") int count) throws InterruptedException {
        Data.reset();
        //多线程循环一定次数调用Data类不同实例的wrong方法
        IntStream.rangeClosed(1, count).parallel().forEach(i -> new Data().wrong());
        return Data.getCounter();
    }

    //正确方法
    @GetMapping("wrong02")
    public String wrong02() throws InterruptedException {
        return "OK";
    }


}
