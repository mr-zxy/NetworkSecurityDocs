package org.example.rabbitMq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.example.rabbitMq.utils.RabbitMq;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class WorkQueueDemo {
    public static void main(String[] args) throws IOException, TimeoutException {
        try {
            Map rabbitMqFactory = RabbitMq.RabbitMqFactory();
            Channel channel = (Channel) rabbitMqFactory.get("channel");
            Connection connection = (Connection) rabbitMqFactory.get("connection");
            channel.queueDeclare("work", true, false, false, null);
            for (int i = 0; i < 100; i++) {
                channel.basicPublish("", "work", MessageProperties.PERSISTENT_TEXT_PLAIN, ("生产者" + i).getBytes());
            }
            RabbitMq.closeConnectionAndChannel(channel, connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
