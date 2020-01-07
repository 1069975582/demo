package com.echo.cache.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class RedisClientTest {

    @Autowired
    private RedisClient redisClient;

    @Test
    void set() {
        redisClient.set("test", "我是测试值");
        log.info(redisClient.get("test"));
    }

    @Test
    void expire() {
        // 设置过期时间
        redisClient.expire("test", 10);
    }

    @Test
    void exists() {
        log.info("键test是否存在: {}", redisClient.exists("test"));
    }

    @Test
    void del() {
        set();
        log.info("删除前, test: {}", redisClient.get("test"));
        redisClient.del("test");
        log.info("删除后, test: {}", redisClient.get("test"));
    }
}