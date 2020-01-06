package com.echo.mq.activemq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Slf4j
@Component
public class Consumer {
    private ConnectionFactory connectionFactory;

    private Connection connection;

    private Session session;

    private ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<>();

    @Autowired
    public Consumer(ActiveMqConfig mqConfig) {
        try {
            connectionFactory = new ActiveMQConnectionFactory(mqConfig.getUserName(), mqConfig.getPassword(), mqConfig.getUrl());
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public String receiveMsg(String queueName) {
        try {
            Queue queue = session.createQueue(queueName);
            MessageConsumer consumer;

            if (threadLocal.get() != null) {
                consumer = threadLocal.get();
            } else {
                consumer = session.createConsumer(queue);
                threadLocal.set(consumer);
            }
            // 阻塞的
            TextMessage message = (TextMessage) consumer.receive();
            if (message != null) {
                message.acknowledge();
                return message.getText();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }
}
