# docke-compose 配置redis
## 创建 volumes 目录
```
mkdir -p /dockerServer/redis/data /dockerServer/redis/logs /dockerServer/redis/conf
chmod -R 777 /dockerServer/redis/data*
chmod -R 777 /dockerServer/redis/logs*
```
## redis.conf配置文件
```
cd /dockerServer/redis/conf
redis.conf
* 复制 ./redis.conf 写进去
* requirepass 你的密码
```
# redis  进入客户端
```
    docker exec -it 71d7eb527c3e redis-cli -h 127.0.0.1 -p 6379 -a 你的密码
```
## 代码中的连接redis IP需要写 “redis”
## 编辑docker-compose.yml文件
``` dockerfile
  redis:
    image: redis
    restart: always
    hostname: redis
    container_name: redis
    privileged: true
    ports:
      - 6379:6379
    environment:
      TZ: Asia/Shanghai
    volumes:
      - /dockerServer/redis/data:/data
      - /dockerServer/redis/conf/redis.conf:/etc/redis/redis.conf
      - /dockerServer/redis/logs:/logs
    command: ["redis-server","/etc/redis/redis.conf"]
```


