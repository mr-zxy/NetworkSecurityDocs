docker 安装详见 https://juejin.cn/post/6844903946062921741#heading-4
## 镜像 

* docker ps 查看运行时镜像
* docker images 查看景象
* docker pull ngnix OR docker run -d nginx:latest 运行一个 nginx 如果没有会去镜像仓库下载
### 镜像删除
* #### docker images 查看docker 镜像
1. 方法一：删除时不要使用 image ID，改用镜像名称（REPOSITORY）
2. 方法二：docker rmi -f imageID
##  docker 系统指令
* 2.1 启动docker服务
* systemctl start docker
* 2.2 停止docker服务
* systemctl stop docker
* 2.3 重启docker服务
* systemctl restart docker
* 2.4 查看docker服务状态
* systemctl status docker
## 列出所有在运行的容器信息
docker ps [OPTIONS] 其他参数

* -a :显示所有的容器，包括未运行的。
* -f :根据条件过滤显示的内容。
* –format :指定返回值的模板文件。
* -l :显示最近创建的容器。
* -n :列出最近创建的n个容器。
* –no-trunc :不截断输出。
* -q :静默模式，只显示容器编号。
* -s :显示总的文件大小。

## docker 启动命令 

* docker container run --publish 80:80  --detach  nginx 
```bat
--detach  在后台运行
```
* docker ps  -a 显示所有的容器，包括未运行的。
* docker rm  CONTAINERID 删除进程
* docker stop CONTAINERID 关闭进程
* docker start CONTAINERID 关闭进程


