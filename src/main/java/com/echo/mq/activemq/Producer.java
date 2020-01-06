package com.echo.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class Producer {
    private ConnectionFactory connectionFactory;

    private Connection connection;

    private Session session;

    private ThreadLocal<MessageProducer> threadLocal = new ThreadLocal();
    @Autowired
    public Producer(ActiveMqConfig mqConfig) {
        try {
            connectionFactory = new ActiveMQConnectionFactory(mqConfig.getUserName(), mqConfig.getPassword(), mqConfig.getUrl());
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String queueName, String msg) {
        try {
            Queue queue = session.createQueue(queueName);
            MessageProducer producer = null;
            if (threadLocal.get() != null) {
                producer = threadLocal.get();
            } else {
                producer = session.createProducer(queue);
                threadLocal.set(producer);
            }
            TextMessage message = session.createTextMessage(msg);
            producer.send(message);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
