package org.example.rabbitMq.fanout;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.example.rabbitMq.utils.RabbitMq;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Consumer {
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
            String QUEUE_NAME="queue";
            String EXCHANGE_NAME="fanout-exchange1";
            // 声明一个fanout交换机
//            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
//            // 声明一个临时队列
//            String queueName = channel.queueDeclare().getQueue();
//            // 将临时队列绑定到交换机上
//            channel.queueBind(queueName, EXCHANGE_NAME, "");

            System.out.println(" [Subscribe-"+"] Waiting for messages.");
            channel.basicConsume(QUEUE_NAME,true,(s, delivery) ->{
                System.out.println( new String(delivery.getBody())+"存到数据库");
            } ,consumerTag-> System.out.println("取消消费"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
