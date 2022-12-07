package com.itheima.mq.messageConfirm;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DirectRabbitConfig {
    // 死性队列
    public static final String DEAD_LETTER_QUEUEA_NAME = "dead.letter.demo.simple.deadletter.queuea";
    public static final String DEAD_LETTER_EXCHANGE = "dead.letter.demo.simple.deadletter.exchange";
    public static final String DEAD_LETTER_QUEUEB_ROUTING_KEY = "dead.letter.demo.simple.deadletter.queueb.routingkey";
    // 正常队列
    public static final String DEAD_BUSINESS_B_QUEUEA_NAME="business.b";
    public static final String DEAD_BUSINESS_B_EXCHANGE_NAME="direct.exchange";
    public static final String DEAD_BUSINESS_B_KEY_NAME="hello";

    // 声明死信队列A
    @Bean("deadLetterQueueA")
    public Queue deadLetterQueueA(){
        return new Queue(DEAD_LETTER_QUEUEA_NAME);
    }
    // 声明死信Exchange
    @Bean("deadLetterExchange")
    public DirectExchange deadLetterExchange(){
        return new DirectExchange(DEAD_LETTER_EXCHANGE);
    }
    // 声明死信队列A绑定关系
    @Bean
    public Binding deadLetterBindingA(@Qualifier("deadLetterQueueA") Queue queue,
                                      @Qualifier("deadLetterExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(DEAD_LETTER_QUEUEB_ROUTING_KEY);
    }
    // 声明业务队列B
    @Bean("businessQueueB")
    public Queue businessQueueB(){
        Map<String, Object> args = new HashMap<>();
        // x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
        // x-dead-letter-routing-key  这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUEB_ROUTING_KEY);
        // 过期时间 如果配置了死性队列 会丢入到死性队列中
        args.put("x-message-ttl", 5000);
        // 队列长度 如果大于长度会被丢入到死性队列中
        args.put("x-max-length",2);
        return QueueBuilder.durable(DEAD_BUSINESS_B_QUEUEA_NAME).withArguments(args).build();
    }

    @Bean
    public DirectExchange directOrderExchange() {return new DirectExchange(DEAD_BUSINESS_B_EXCHANGE_NAME, true, false);}

    @Bean
    public Binding bindingDirect2() {
        return BindingBuilder.bind(businessQueueB()).to(directOrderExchange()).with(DEAD_BUSINESS_B_KEY_NAME);
    }
}
