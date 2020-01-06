package com.echo.mq.activemq;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ActiveMqConfig {

    @Value("${mq.active.username}")
    private String userName;

    @Value("${mq.active.password}")
    private String password;

    @Value("${mq.active.broker.url}")
    private String url;
}