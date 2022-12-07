package org.example.rabbitMq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class RabbitMq {
    /**
     * 连接
     * @return
     * @throws IOException`
     * @throws TimeoutException
     */
    public static Map RabbitMqFactory() throws IOException, TimeoutException {
        // 创建链接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置ip
        factory.setHost("127.0.0.1");
        factory.setUsername("admin");
        factory.setPassword("admin");
        // 创建链接
        Connection connection = factory.newConnection();
        // 获取信道
        Channel channel = connection.createChannel();
        Map factoryMap = new HashMap() {
            {
                put("connection", connection);
                put("channel", channel);
            }
        };
        return factoryMap;
    }

    /**
     * 关闭
     * @param channel
     * @param connection
     */
    public static void closeConnectionAndChannel(Channel channel, Connection connection) {
        try {
            if(channel!=null){
                channel.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
