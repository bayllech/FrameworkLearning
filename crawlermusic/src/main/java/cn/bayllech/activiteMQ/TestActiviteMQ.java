package cn.bayllech.activiteMQ;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

/**
 * Created by bayllech on 2017/11/30.
 */

public class TestActiviteMQ {

    @Test
    public void productMessage() throws JMSException {
        String brokerURL = "tcp://localhost:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(true,Session.CLIENT_ACKNOWLEDGE);

        Destination destination = session.createQueue("test-MQ");
        MessageProducer producer = session.createProducer(destination);
        //持久化 默认2
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        TextMessage textMessage = session.createTextMessage("hello,MQ1");
        producer.send(textMessage);

        session.commit();

        producer.close();
        session.close();
        connection.close();
    }

    @Test
    public void consumerMessage() throws JMSException, IOException {
        String brokerURL = "tcp://localhost:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue("test-MQ");
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.out.println(">>>>>" + message);
                try {
                    message.acknowledge();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();

        consumer.close();
        session.close();
        connection.close();
    }


}
