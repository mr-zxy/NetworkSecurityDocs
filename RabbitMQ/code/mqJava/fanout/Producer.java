package org.example.rabbitMq.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.example.rabbitMq.utils.RabbitMq;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(org.example.rabbitMq.simple.Producer.class);

    //    发消息
    public static void main(String[] args) throws IOException, TimeoutException {

        Map rabbitMqFactory = RabbitMq.RabbitMqFactory();
        Channel channel = (Channel) rabbitMqFactory.get("channel");
        Connection connection = (Connection) rabbitMqFactory.get("connection");
        try {
            String EXCHANGE_NAME = "fanout-exchange1";
            String QUEUE_NAME="queue";
            String message = "Publish-" + System.nanoTime();
            // 声明队列
            channel.queueDeclare(QUEUE_NAME, false, false, true, null);

            // 表示声明了一个交换机
            channel.exchangeDeclare(EXCHANGE_NAME,BuiltinExchangeType.FANOUT, false, false, null);
            // 绑定关系
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,QUEUE_NAME);
            // 发送消息
            channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println(" [Publish] Sent '" + message + "'");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            // 关闭连接
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
