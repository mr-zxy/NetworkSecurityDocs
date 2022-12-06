> 交换机共有四种类型
* 扇出(fanout)
* 直接(direct)
* 主题(topic)
* 标题(headers)

1. fanout 广播模式 只要有一个订阅都会收到消息
2. direct 路由模式 根据路由key进行匹配
3. topic  主题模式 增加模糊匹配路由key
    * \# 零个一个或多个 (com.xxx 对应 routing key com.#) 
    * \* 至少有一个,只有一级 
        + 例子 队列一 key *.course.* 队列2 #.order.# 对应 com.course.order 两个队列都可以收到
4. headers 参数模式 根据参数进行发送消息
    !["headers"](./images/2.png)

5. work消息模型【能者多劳】
> 不同消费者可能消费消息的速度不一样，work模型通过手动确认机制实现能者多劳多个消费者通过自动确认机制

    1. 轮训分发消息 自动消费
    2. 手动消费
    # 详见demo

1. 死性队列
    * 设置ttl 没有消费者消费 过期会进入死性队列
    * 设置消费之 设置ttl 消费成功不会进入死性队列
