1. docker pull nginx:1.17.8
2. docker run --name nginxtest -p 9091:80 -d nginx:1.17.8
3. ```
    mkdir -p /server/nginx/www
    mkdir -p /server/nginx/logs
    mkdir -p /server/nginx/conf
    ```
4. docker cp e897031a474f:/etc/nginx/nginx.conf /server/nginx/conf
5. docker run -d -p 9091:80 --name nginx -v /server/nginx/www:/usr/share/nginx/html -v /server/nginx/conf/nginx.conf:/etc/nginx/nginx.conf -v /server/nginx/logs:/var/log/nginx nginx:1.17.8
6. cd ./www ; echo hello>index.html

7. 访问 http://192.168.1.26:9091/