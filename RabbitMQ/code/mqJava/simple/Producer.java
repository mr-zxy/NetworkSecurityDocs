package org.example.rabbitMq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.example.rabbitMq.utils.RabbitMq;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static final String QUEUE_NAME = "hello";
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Producer.class);

    //    发消息
    public static void main(String[] args) throws IOException, TimeoutException {

        Map rabbitMqFactory = RabbitMq.RabbitMqFactory();
        Channel channel = (Channel) rabbitMqFactory.get("channel");
        Connection connection = (Connection) rabbitMqFactory.get("connection");
        try {
            /**
             * 队列
             * 1. 名称
             * 2. 是否持久化（持久化存内存）
             * 3. 该队列是否只对一个消费者（消息共享）
             * 4. 开连接队列是否自动删除
             * 5. 其他参数
             */
            channel.queueDeclare(QUEUE_NAME, true, false, true, null);
            // 发消息
            String message = "hello word1";
            /**
             * 发送消息
             * 1. 到哪个交换机
             * 2. 路由key值，队列名称
             * 3. 其它参数
             * 4. 发送消息的消息体（二级制）
             */
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.printf("发送成功啦");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
//             关闭通道
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
