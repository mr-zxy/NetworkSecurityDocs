package com.itheima.mq.messageConfirm;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.itheima.mq.messageConfirm.DirectRabbitConfig.DEAD_BUSINESS_B_QUEUEA_NAME;

@RabbitListener(queues = DEAD_BUSINESS_B_QUEUEA_NAME)
@Component
public class ConsumerDead {
    @RabbitHandler
    public void messagerevice(String message){
        System.out.println("死性队列消息"+message);
    }
}
