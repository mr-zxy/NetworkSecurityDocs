docker 安装详见 https://juejin.cn/post/6844903946062921741#heading-4

docker run -d nginx:latest 运行一个 nginx 如果没有会去镜像仓库下载
docker ps 查看进程

2 系统指令
2.1 启动docker服务
systemctl start docker
2.2 停止docker服务
systemctl stop docker
2.3 重启docker服务
systemctl restart docker
2.4 查看docker服务状态
systemctl status docker
