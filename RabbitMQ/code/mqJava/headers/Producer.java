package org.example.rabbitMq.headers;

import com.rabbitmq.client.AMQP.BasicProperties.Builder;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.example.rabbitMq.utils.RabbitMq;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(org.example.rabbitMq.simple.Producer.class);

    //    发消息
    public static void main(String[] args) throws IOException, TimeoutException {

        Map rabbitMqFactory = RabbitMq.RabbitMqFactory();
        Channel channel = (Channel) rabbitMqFactory.get("channel");
        Connection connection = (Connection) rabbitMqFactory.get("connection");
        /**
         * 1. 创建队列需要填写队列名称
         * 2. 交换机名称必须正确
         * 3. DIRECT_KEY 为空
         * 4. 使用参数进行匹配 需要存储map
         */
        try {
            Map<String,Object> headers =  new Hashtable<String, Object>();
            headers.put("y", "1");
            Builder properties = new Builder();
            properties.headers(headers);

            String EXCHANGE_NAME = "headers-exchange";
            String QUEUE_NAME="headers-queue"; // headers-queue
            String DIRECT_KEY="";
            String message = "Publish-" + System.nanoTime();
            BuiltinExchangeType Builtin_Exchange_Type=BuiltinExchangeType.HEADERS;
            // 声明队列
            channel.queueDeclare(QUEUE_NAME, false, false, true, null);
            // 表示声明了一个交换机
            channel.exchangeDeclare(EXCHANGE_NAME,Builtin_Exchange_Type, false, false, null);
            // 绑定关系
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,DIRECT_KEY,headers);
            // 发送消息
            channel.basicPublish(EXCHANGE_NAME, DIRECT_KEY, properties.build(), message.getBytes("UTF-8"));
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
