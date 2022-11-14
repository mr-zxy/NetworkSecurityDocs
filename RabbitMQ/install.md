## rabbitmq 安装
1. RabbitMQ是采用Erlang语言开发的，所以系统环境必须提供Erlang环境。
    ``` shell
    brew install rabbitmq
    ```
2. 启动RabbitMq服务
    ``` shell
    brew services start rabbitmq;
    ```
3. RabbitMQWeb管理界面及授权操作，后台管理界面插件安装
    ``` shell
    rabbitmq-plugins enable rabbitmq_management
    ```
4. http://localhost:15672/ 访问 guest 默认账号密码

> 命令

|  操作命令   | 说明  |
|  ----  | ----  |
|rabbitmqctl list_users| 查看用户列表|
|rabbitmqctl add_user admin admin | 添加用户|
|rabbitmqctl set_user_tags admin administrator| 设置管理员（用户查看底下用户权限）(不能通过 java后台访问)|
|rabbitmqctl set_permissions -p "/" admin ".*" ".*" ".*"|设置权限(java 可以访问)

>  端口 

|  端口   | 说明  |
|  ----  | ----  |
| 5672  | RabbitMQ的通讯端口 |
| 25672  | RabbitMQ的节点间的CLI通讯端口 |
| 15672  | RabbitMQ HTTP_API的端口，管理员用户才能访问，用于管理RabbitMQ,需要启动Management插件 |
| 1883、8883  | MQTT插件启动时的端口 |
| 61613、61614  | STOMP客户端插件启用的时候的端口 |
| 15674、15675  | 基于webscoket的STOMP端口和MOTT端口 |

> 用户权限

|角色|权限|
|----|----|
|administrator| 可以登录控制台、查看所有信息、可以对rabbitmq进行管理|
|monitoring| 监控者，登录控制台，查看所有信息|
|policymaker| 策略制定者，登录控制台，指定策略|
|managment|	普通管理员，登录控制台|

