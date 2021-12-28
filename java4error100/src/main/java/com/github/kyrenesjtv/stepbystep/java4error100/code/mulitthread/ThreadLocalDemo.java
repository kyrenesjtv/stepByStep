package com.github.kyrenesjtv.stepbystep.java4error100.code.mulitthread;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huojianxiong
 * @Description 关于使用threadLocal时候因为线程重用，从而产生的问题
 * @Date 2021/12/28 11:37
 */
@RequestMapping("/demo")
@RestController
public class ThreadLocalDemo {

    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);

    //再配置文件中设置了server.tomcat.threads.max=1 从而模拟容器内部的线程池被用光的场景
    @GetMapping("wrong1")
    public Map wrong1(@RequestParam("userId") Integer userId) {
        //设置用户信息之前，先查询一次threadLocal中的用户信息
        String befor = Thread.currentThread().getName() + ":" + currentUser.get();
        //设置用户信息到threadLocal中
        currentUser.set(userId);
        //设置用户信息之后，再查询一次threadLocal当中的信息
        String after = Thread.currentThread().getName() + ":" + currentUser.get();
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("befor", befor);
        resultMap.put("after", after);
        return resultMap;
    }

    //修正后，显示清除threadLocal中的数据，再用完threadLocal之后，将数据清除
    @GetMapping("wrong2")
    public Map wrong2(@RequestParam("userId") Integer userId) {
        //设置用户信息之前，先查询一次threadLocal中的用户信息
        String befor = Thread.currentThread().getName() + ":" + currentUser.get();
        //设置用户信息到threadLocal中
        currentUser.set(userId);
        try {
            //设置用户信息之后，再查询一次threadLocal当中的信息
            String after = Thread.currentThread().getName() + ":" + currentUser.get();
            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("befor", befor);
            resultMap.put("after", after);
            return resultMap;
        } finally {
            currentUser.remove();
        }

    }


}
