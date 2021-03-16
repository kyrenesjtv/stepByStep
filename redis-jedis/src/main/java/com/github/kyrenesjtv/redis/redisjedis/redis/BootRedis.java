package com.github.kyrenesjtv.redis.redisjedis.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2021/1/14 10:03
 */
@SpringBootTest
public class BootRedis {

    @Autowired
    private RedisTemplate redisTemplate;//默认127.0.0.1 6379 jdk序列化

    @Autowired
    private StringRedisTemplate stringRedisTemplate;//key value string序列化

    @Test
    void testRedis(){

        //修改Key的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //修改hash key的序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

//        stringRedisTemplate.opsForValue().set("k1","v1");

        System.out.println(redisTemplate.opsForValue().get("v1"));//两者的数据分离
        System.out.println(stringRedisTemplate.opsForValue().get("v1"));

//        redisTemplate.opsForList().range("names",0,-1);
//
//        redisTemplate.opsForValue().set("key",123,120,TimeUnit.SECONDS);
//
//        redisTemplate.opsForHash().put("maps","name","aw");


        //绑定key
        BoundValueOperations<String, String> name = stringRedisTemplate.boundValueOps("name");
        name.set("aw");
        name.append("123");
        System.out.println(name.get());

        /**
         * 1：验证码,超时时间
         * 2：时效性的业务功能  - 预提交的功能 - 待付款
         * 3：分布式session
         * 4：zset 排行榜
         * 5：分布式缓存
         * 6：存储token -- 时效性
         * 7：分布式锁
         */


    }
}
