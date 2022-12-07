## 基本使用
1. rabbitmqctl list_queues 查看所有队列
2. rabbitmqctl delete_queue queue_name 根据 queue_name 参数，删除对应的队列


## 消息不丢失 
> 发布
1. channel.confirmSelect() 开启发送方确认模式 正常确认
2. 极端情况下，没有走confirmSelect方法，需要先数据存储到数据库或者存储到redis
> 消费
1. 开启ack 自动确认机制，配合死性队列使用。如果消息过期或者报错，把数据添加到死性队列中，在进行发送。 或者配置重发次数参数。 

> 生产数据可靠性 通过 rabbitTemplate.setConfirmCallback 方法监听mq是否接收到消息。[生产SpringBoot代码](http://baidu.com)
```java
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
```
> 手动确认消费 保证消费准确性 使用 try catch + 手动确认 + 死性队列 [消费SpringBoot代码](http://baidu.com)
```java
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
```
