package com.itheima.mq.messageConfirm;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.UUID;

import static com.itheima.mq.messageConfirm.DirectRabbitConfig.*;

@Component
@RestController
public class OrderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 消息可靠性
     * spring:
     *   rabbitmq:
     *     host: 127.0.0.1
     *     password: admin
     *     username: admin
     *     publisher-confirm-type: correlated 需要配置此选项
     *     listener:
     *       type: simple
     *       simple:
     *         default-requeue-rejected: false
     *         acknowledge-mode: manual
     */
    @PostConstruct
    public void regCallback(){
        /**
         * @param correlationData 相关配置信息
         * @param ack   exchange交换机 是否成功收到了消息。true 成功，false代表失败
         * @param cause 失败原因
         */
        rabbitTemplate.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause)->{
//            System.out.println("----");
            System.out.println("消息生产可靠性回调："+correlationData.getId());
//            System.out.println(ack);
//            System.out.println(cause);
//            System.out.println("----");
        });
    }
    @GetMapping("/message")
    public void makeOrder(String userId) {
        String orderNumer = UUID.randomUUID().toString();
        System.out.println("用户 " + userId + ",订单编号是：" + orderNumer);
        rabbitTemplate.convertAndSend(DEAD_BUSINESS_B_EXCHANGE_NAME, DEAD_BUSINESS_B_KEY_NAME, orderNumer,new CorrelationData(orderNumer));
    }

    // 死性队列 手动添加
    @GetMapping("/message1")
    public void makeOrder1(String userId) {
        String orderNumer = UUID.randomUUID().toString();
        System.out.println("用户 " + userId + ",订单编号是：" + orderNumer);
        rabbitTemplate.convertAndSend(DEAD_LETTER_EXCHANGE, DEAD_LETTER_QUEUEB_ROUTING_KEY, orderNumer);
    }
}
