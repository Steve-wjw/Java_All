package com.steve.demo;

import com.steve.demo.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: STEVE
 * @Description: SpringBoot整合Redis测试案例
 * @since: 2023/12/20
 */
@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void redisContextLoads() {
        // 判断key是否存在
        System.out.println(redisUtil.hasKey("myKey"));
        System.out.println("==========String===========");
        // String 缓存测试
        redisUtil.set("s1", "one");
        System.out.println(redisUtil.get("s1"));
        redisUtil.set("n1", 5);
        redisUtil.incr("n1", 5);
        System.out.println(redisUtil.get("n1"));
        System.out.println("==========Map===========");
        // Map 缓存测试
        Map map = new HashMap<String, Integer>();
        map.put("k1", 5);
        map.put("k2", 10);
        redisUtil.hmset("m1", map);
        System.out.println(redisUtil.hget("m1", "k1"));
        System.out.println(redisUtil.hmget("m1"));
        System.out.println(redisUtil.hHasKey("m1", "k1"));
        redisUtil.hdel("m1", "k1");
        System.out.println(redisUtil.hHasKey("m1", "k1"));
        redisUtil.hincr("m1", "k2", 10d);
        System.out.println(redisUtil.hget("m1", "k2"));
        System.out.println("==========Set===========");
        redisUtil.sSet("set1", "a", "b", "c", "c");
        System.out.println(redisUtil.sHasKey("set1", "a"));
        System.out.println(redisUtil.sHasKey("set1", "d"));
        System.out.println(redisUtil.sGet("set1"));
        System.out.println(redisUtil.sGetSetSize("set1"));
        redisUtil.setRemove("set1", "c");
        System.out.println(redisUtil.sGetSetSize("set1"));
        System.out.println("==========list===========");
        redisUtil.lSet("list1", "l1");
        redisUtil.lSet("list1", "l2");
        redisUtil.lSet("list1", "l3");
        System.out.println(redisUtil.lGet("list1", 0, -1));
        System.out.println(redisUtil.lGetListSize("list1"));
        System.out.println(redisUtil.lGetIndex("list1", 1));
        redisUtil.lUpdateIndex("list1", 1, "newValue");
        System.out.println(redisUtil.lGetIndex("list1", 1));
        System.out.println(redisUtil.lGet("list1", 0, -1));
        redisUtil.lRemove("list1", 1, "l3");
        System.out.println(redisUtil.lGet("list1", 0, -1));
    }

}
