# docke-compose 配置mysql
## 创建 volumes 目录
```
mkdir -p /home/mysql/conf /home/mysql/logs /home/mysql/data
chmod -R 777 /home/mysql/data*
chmod -R 777 /home/mysql/logs*
```
# 进入 mysql 客户端
```
    docker exec -it 37a847ee5b9d /bin/bash
```
## mysql
1. 初始密码 root
2. mysql -u root -p
## 编辑docker-compose.yml文件
``` dockerfile
mysql:
    container_name: mysql
    restart: always
    image: mysql:5.7
    ports:
      - "3306:3306"
    volumes:
      - /home/mysql/conf:/etc/mysql/conf.d
      - /home/mysql/logs:/logs
      - /home/mysql/data:/var/lib/mysql
    command: [
          'mysqld',
          '--innodb-buffer-pool-size=80M',
          '--character-set-server=utf8mb4',
          '--collation-server=utf8mb4_unicode_ci',
          '--default-time-zone=+8:00',
          '--lower-case-table-names=1'
        ]
    environment:
      MYSQL_ROOT_PASSWORD: root
```
