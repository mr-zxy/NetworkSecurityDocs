package org.example.rabbitMq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.example.rabbitMq.utils.RabbitMq;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Consumer {
    private static final String QUEUE_NAME="hello";


    public static void main(String[] args) throws IOException, TimeoutException {

        Map rabbitMqFactory = RabbitMq.RabbitMqFactory();
        Channel channel = (Channel) rabbitMqFactory.get("channel");
        Connection connection = (Connection) rabbitMqFactory.get("connection");
        try{
            /**
             * 消费者
             * 1. 消费哪个队列
             * 2. 消费成功是否自动应答
             * 3. 消费者未成功消费的回调
             * 4. 消费者取消消费的回调
             */
            channel.basicConsume(QUEUE_NAME,true,(s, delivery) ->{
                System.out.println( new String(delivery.getBody())+"存到数据库");
//                if (channel != null && channel.isOpen()) {
//                    try {
//                        channel.close();
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                }
//                // 关闭连接
//                if (connection != null && connection.isOpen()) {
//                    try {
//                        connection.close();
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                }
            } ,consumerTag-> System.out.println("取消消费"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
