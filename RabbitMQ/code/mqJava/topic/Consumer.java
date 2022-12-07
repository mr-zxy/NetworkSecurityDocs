package org.example.rabbitMq.topic;


import com.rabbitmq.client.Channel;
import org.example.rabbitMq.utils.RabbitMq;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {

        Map rabbitMqFactory = RabbitMq.RabbitMqFactory();
        Channel channel = (Channel) rabbitMqFactory.get("channel");

        try{
            String QUEUE_NAME="topic-queue";
            System.out.println(" [Subscribe-"+"] Waiting for messages.");
            channel.basicConsume(QUEUE_NAME,true,(s, delivery) ->{
                System.out.println( new String(delivery.getBody())+"存到数据库");
            } ,consumerTag-> System.out.println("取消消费"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
