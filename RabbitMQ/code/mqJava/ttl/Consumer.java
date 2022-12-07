package org.example.rabbitMq.ttl;

import com.rabbitmq.client.*;
import org.example.rabbitMq.utils.RabbitMq;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Map rabbitMqFactory = RabbitMq.RabbitMqFactory();
        Channel channel = (Channel) rabbitMqFactory.get("channel");
        Connection connection = (Connection) rabbitMqFactory.get("connection");
        try {
//            channel.basicConsume("ttl.queue", true, new DefaultConsumer(channel){
//                @Override
//                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                    System.out.println(properties);
//                    System.out.println("获取的消息是：" + new String(body,"UTF-8"));
//                }
//            });

            channel.basicConsume("ttl.queue",true,(s, delivery) ->{
                System.out.println( new String(delivery.getBody())+"存到数据库");
            } ,consumerTag-> System.out.println("取消消费"));

            System.out.println("开始接受消息");
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 7: 释放连接关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
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
