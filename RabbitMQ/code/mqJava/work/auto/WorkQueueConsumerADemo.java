package org.example.rabbitMq.work.auto;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.example.rabbitMq.utils.RabbitMq;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class WorkQueueConsumerADemo {
    public static void main(String[] args) throws  IOException, TimeoutException {
        Map rabbitMqFactory = RabbitMq.RabbitMqFactory();
        Channel channel = (Channel) rabbitMqFactory.get("channel");
        channel.queueDeclare("work", true, false, false, null);
        channel.basicConsume("work", true,new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumerA:"+new String(body));
            }
        });
    }
}
