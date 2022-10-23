# Docker-Compose
## Compose 项目是 Docker 官方的开源项目，负责实现对 Docker 容器集群的快速编排。使用前面介绍的Dockerfile我们很容易定义一个单独的应用容器。然而在日常开发工作中，经常会碰到需要多个容器相互配合来完成某项任务的情况。例如要实现一个 Web 项目，除了 Web 服务容器本身，往往还需要再加上后端的数据库服务容器；再比如在分布式应用一般包含若干个服务，每个服务一般都会部署多个实例。如果每个服务都要手动启停，那么效率之低、维护量之大可想而知。这时候就需要一个工具能够管理一组相关联的的应用容器，这就是Docker Compose。

1. Compose有2个重要的概念：
    * 项目（Project）：由一组关联的应用容器组成的一个完整业务单元，在 docker-compose.yml 文件中定义。
    * 服务（Service）：一个应用的容器，实际上可以包括若干运行相同镜像的容器实例。

2. 安装 
    * www https://docs.docker.com/compose/install/
    * sudo curl -L https://github.com/docker/compose/releases/download/1.16.1/docker-compose-`uname  -s`-`uname -m` -o /usr/local/bin/docker-compose 下载最新版的docker-compose文件 
    * sudo curl -L https://get.daocloud.io/docker/compose/releases/download/1.25.1/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose  若是github访问太慢，可以用daocloud下载
    * sudo chmod +x /usr/local/bin/docker-compose 添加可执行权限
    * sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose root用户无法使用 
    * docker-compose --version 查看版本
    * demo https://docs.docker.com/compose/gettingstarted/
    
3. 运行 
    * docker-compose up 启动
    * docker-compose down 关闭