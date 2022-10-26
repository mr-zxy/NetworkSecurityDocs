## docker 启动
1. docker pull nginx:1.17.8
2. docker run --name nginxtest -p 9091:80 -d nginx:1.17.8
3. ```
    mkdir -p /home/nginx/www
    mkdir -p /home/nginx/logs
    mkdir -p /home/nginx/conf
    ```
4. docker cp e897031a474f:/etc/nginx/nginx.conf /home/nginx/conf
  * 这句话复制出来可能会是文件夹，需要手动创建文件  /home/nginx/conf/nginx.conf
  ``` nginx
user  nginx;
worker_processes  1;
error_log  /var/log/nginx/error.log warn;
pid        /var/run/nginx.pid;
events {
    worker_connections  1024;
}
http {
    include       /etc/nginx/mime.types;
    default_type  application/octet-stream;

    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    access_log  /var/log/nginx/access.log  main;
    sendfile        on;
    #tcp_nopush     on;
    keepalive_timeout  65;
    #gzip  on;
    include /etc/nginx/conf.d/*.conf;
}

  ```
5. docker run -d -p 9091:80 --name nginx1 -v /home/nginx/www:/usr/share/nginx/html -v /home/nginx/conf/nginx.conf:/etc/nginx/nginx.conf -v /home/nginx/logs:/var/log/nginx nginx:1.17.8
6. cd /home/nginx/www ; echo hello>index.html

7. 访问 http://192.168.1.26:9091/


## docker-compose 启动
1. docker pull nginx:1.17.8
2. docker run --name nginxtest -p 9091:80 -d nginx:1.17.8
3. ```
    mkdir -p /home/nginx/www
    mkdir -p /home/nginx/logs
    mkdir -p /home/nginx/conf
    ```
 ``` dockerfile
 nginx:
    image: nginx:1.17.8
    restart: always
    container_name: nginx
    environment:
      - TZ=Asia/Shanghai
    ports:
      - 80:80
      - 443:443
    volumes:
      - /home/nginx/www:/usr/share/nginx/html
      - /home/nginx/conf/nginx.conf:/etc/nginx/nginx.conf
      - /home/nginx/logs:/var/log/nginx
 ```