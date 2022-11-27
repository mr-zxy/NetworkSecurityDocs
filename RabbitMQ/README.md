## 基本使用
1. rabbitmqctl list_queues 查看所有队列
2. rabbitmqctl delete_queue queue_name 根据 queue_name 参数，删除对应的队列


## 消息不丢失 
> 发布
1. channel.confirmSelect() 开启发送方确认模式 正常确认
2. 极端情况下，没有走confirmSelect方法，需要先数据存储到数据库或者存储到redis
> 消费
1. 开启ack 自动确认机制，配合死性队列使用。如果消息过期或者报错，把数据添加到死性队列中，在进行发送。 或者配置重发次数参数。

[参考文献](https://juejin.cn/post/7132268340541653005)  