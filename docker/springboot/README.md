# springBoot 部署
## 基础SpringBoot
1. 创建DockerFile
2. 编写
    ./Dockerfile
3. 生成镜像 
    * docker build -t demo:1.0 .
4. 运行镜像
    * docker run --name demo --restart=always -d -p 8080:8080 demo:1.0