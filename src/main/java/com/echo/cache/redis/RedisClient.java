package com.echo.cache.redis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisClient {
    private Jedis jedis;

    public RedisClient(RedisConfig redisConfig) {
        jedis = new Jedis(redisConfig.getHost(), redisConfig.getPort());
    }

    public void set(String key, String value) {
        jedis.set(key, value);
    }

    public long expire(String key, int seconds) {
        return jedis.expire(key, seconds);
    }

    public String get(String key) {
        return jedis.get(key);
    }

    public boolean exists(String key) {
        return jedis.exists(key);
    }

    public Long del(String key) {
        return jedis.del(key);
    }
}
