package com.echo.mq.activemq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerTest {

    @Autowired
    private Producer producer;

    @Test
    void sendMsg() {
        String queueName = "Test";
        String msg = "我是发送的数据!";
        producer.sendMsg(queueName, msg);
    }
}