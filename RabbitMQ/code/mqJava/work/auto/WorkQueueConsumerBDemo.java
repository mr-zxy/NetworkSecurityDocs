package org.example.rabbitMq.work.auto;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.example.rabbitMq.utils.RabbitMq;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class WorkQueueConsumerBDemo {
    public static void main(String[] args) throws  IOException, TimeoutException {
        Map rabbitMqFactory = RabbitMq.RabbitMqFactory();
        Channel channel = (Channel) rabbitMqFactory.get("channel");
        channel.queueDeclare("work", true, false, false, null);
        channel.basicConsume("work",true, new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(1000);  // 消费者A与消费者B的区别
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("consumerB:"+new String(body));
            }
        });
    }
}
