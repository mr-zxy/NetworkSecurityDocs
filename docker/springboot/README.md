# springBoot 部署
## 基础SpringBoot
1. 创建DockerFile
2. 编写
    ``` dockerfile
    FROM openjdk:8-jdk-alpine
    VOLUME /tmp
    COPY *.jar demo.jar
    ENTRYPOINT ["java","-jar","/demo.jar"]
    ```
3. 生成镜像 
    * docker build -t demo:1.0 .
4. 运行镜像
    * docker run --name demo --restart=always -d -p 8080:8080 demo:1.0
        
## docker-compose redis 部署
    1. 新建

 # redis  进入客户顿
 * docker exec -it 71d7eb527c3e redis-cli -h 127.0.0.1 -p 6379 -a REDIS_ZXY_PASSWORD_abc_456

172.20.0.2
172.17.0.2 
172.17.0.3

https://blog.csdn.net/m0_50638181/article/details/123615781

joinVerifyApi