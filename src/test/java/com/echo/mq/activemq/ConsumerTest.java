package com.echo.mq.activemq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerTest {

    @Autowired
    private Consumer consumer;

    @Test
    void receiveMsg() {
        String queueName = "Test";
        System.out.println(consumer.receiveMsg(queueName));
    }
}