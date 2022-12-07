package com.itheima.mq.messageConfirm;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.itheima.mq.messageConfirm.DirectRabbitConfig.DEAD_BUSINESS_B_QUEUEA_NAME;

@RabbitListener(queues = DEAD_BUSINESS_B_QUEUEA_NAME)
@Component
public class ConsumerB {

    @RabbitHandler
    public void messagerevice(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        try {
            /**
             * 消费数据
             * deliveryTag  设备id
             * multiple 参数设置为false 则表示拒绝编号为deliveryTag的这一条消息，这时候basicNack 和basicReject 方法一样;multiple 参数设置为true 则表示拒绝deliveryTag 编号之前所有未被当前消费者确认的消息。
             */
            channel.basicAck(deliveryTag, true);
            System.out.println("消费成功"+message);
        } catch (Exception ex) {
            System.out.println(ex);
            /**
             * 拒绝消费数据
             * deliveryTag  设备id
             * multiple 参数设置为false 则表示拒绝编号为deliveryTag的这一条消息，这时候basicNack 和basicReject 方法一样;multiple 参数设置为true 则表示拒绝deliveryTag 编号之前所有未被当前消费者确认的消息。
             * requeue:true为将消息重返当前消息队列,还可以重新发送给消费者;   false:将消息丢弃 如果有死性队列 会被丢入死性队列中
             */
            channel.basicNack(deliveryTag, false, false);
            System.out.println("消费失败"+message);
        }
    }
}