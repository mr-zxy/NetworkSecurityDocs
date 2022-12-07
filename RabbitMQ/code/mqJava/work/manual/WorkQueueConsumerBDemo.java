package org.example.rabbitMq.work.manual;

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
        /**
         * 每次只能消费一个消息【切记这里需要设置】
         */
        channel.basicQos(1);
        channel.queueDeclare("work", true, false, false, null);
        /**
         * 第1个参数：队列名
         * 第2个参数：自动确认
         * 第3个参数：回调方法，用于处理消息
         */
        channel.basicConsume("work", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
//                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("consumerA:" + new String(body));
                /**
                 * 手动确认
                 * 第1个参数：通过发送Tag标识来确认消费的是消息队列中的哪个消息
                 * 第2个参数：是否开启多个消息同时确认，这里我们设置了每次只能消费一个消息，因此不需要开启
                 */
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
