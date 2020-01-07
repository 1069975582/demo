package com.echo.cache.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class RedisConfig {

    @Value("${cached.redis.host}")
    private String host;

    @Value("${cached.redis.port}")
    private Integer port;
}
