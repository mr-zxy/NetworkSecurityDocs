## docker 启动
1. docker pull nginx:1.17.8
2. docker run --name nginxtest -p 9091:80 -d nginx:1.17.8
3. ```
    mkdir -p /home/nginx/www
    mkdir -p /home/nginx/logs
    mkdir -p /home/nginx/conf
    ```
4. docker cp e897031a474f:/etc/nginx/nginx.conf /home/nginx/conf
5. docker run -d -p 9091:80 --name nginx1 -v /home/nginx/www:/usr/share/nginx/html -v /home/nginx/conf/nginx.conf:/etc/nginx/nginx.conf -v /home/nginx/logs:/var/log/nginx nginx:1.17.8
6. cd /home/nginx/www ; echo hello>index.html

7. 访问 http://192.168.1.26:9091/


## docker-compose 启动
  * 注意：上一步也要执行 docker-compose 相对复杂
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