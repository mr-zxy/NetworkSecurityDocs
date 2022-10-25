# node 部署教程
<!-- ## wget http://192.168.1.134:5000/Dockerfile -->
## docker build -t node-server:1.0 .
## docker run --name=nodeServer --restart=always -p 8000:8000 -d  node-server:1.0