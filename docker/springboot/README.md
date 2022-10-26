# springBoot 部署
## 基础SpringBoot
1. 创建DockerFile
2. 编写
    ./Dockerfile
3. 生成镜像 
    * docker build -t framework:1.0 .
* 运行镜像
    * docker run --name frameworkJ --restart=always -d -p 8080:8080 framework:1.0
* docker-compose 运行
    * docker-compose up