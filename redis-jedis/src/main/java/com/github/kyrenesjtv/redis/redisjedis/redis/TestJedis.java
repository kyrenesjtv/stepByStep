package com.github.kyrenesjtv.redis.redisjedis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2021/1/13 17:13
 */
public class TestJedis {



    private static ShardedJedisPool pool;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(50);
        config.setMaxWaitMillis(3000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        // 集群
        JedisShardInfo jedisShardInfo1 = new JedisShardInfo("127.0.0.1", 6379);
        jedisShardInfo1.setPassword("12345");
        List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
        list.add(jedisShardInfo1);
        pool = new ShardedJedisPool(config, list);
    }


    public static void main(String[] args) {
        //单机
        Jedis jedis1 = new Jedis("127.0.0.1", 6379);
        jedis1.auth("12345");
        Transaction multi = jedis1.multi();
        multi.exec();
        multi.discard();
        //集群
        ShardedJedis jedis = pool.getResource();
        jedis.set("k1", "v1");
        System.out.println(jedis.get("k1"));


    }
}
