# Nessus 扫描log4J漏洞

## 1.扫描环境搭建

##### 1.centos7 安装装宝塔面板

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/0441e1bbb16a4097a848d126df6ad17a.png)

##### 2.面板里下载docker

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/de849a33389c490bb17d0eac6a96fecb.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/519f4443f1814959b11df6d88aac4145.png)

##### 3.进入centos检查docker是否生效

```
docker --version
```

##### 4.安装docker-compose

Docker Compose是一个用来定义和运行复杂应用的Docker工具。一个使用Docker容器的应用，通常由多个容器组成。使用Docker Compose不再需要使用shell脚本来启动容器。

Compose 通过一个配置文件来管理多个Docker容器，在配置文件中，所有的容器通过services来定义，然后使用docker-compose脚本来启动，停止和重启应用，和应用中的服务以及所有依赖服务的容器，非常适合组合使用多个容器进行开发的场景。

参考：[https://docs.docker.com/compose/install/](https://docs.docker.com/compose/install/)

4.1 下载 docker-compose

```
curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/021b03ca8c80487f9195adc1109febbd.png)

4.2 查看docker-compose

```
ls /usr/local/bin/
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/07d926dcfd0d42d99b24743b674def58.png)

4.3 给docker-compose目录增加可执行权限

```
chmod +x /usr/local/bin/docker-compose
ls /usr/local/bin/
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/1a52eca9ba98451e9944261df831b9e1.png)

4.4 查看版本

```
docker-compose -version
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/2e178bf8083d40e8a8a2a4626dce321a.png)

##### 5.安装vulhub

5.1 创建zsoft文件夹

```
cd /www/wwwroot/
ls
mkdir softs
ls
cd softs
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/100e72d253494a77865a0ef28e3853e0.png)

5.2 下载 vulhub,并查看

```
git clone https://github.com/vulhub/vulhub.git
ls
cd vulhub
ls
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/f07e9e024a4845c3b9b041e2e551536d.png)

##### 6.部署log4J靶场

6.1 进入log4j/CVE-2021-44228

```
cd log4j/CVE-2021-44228
ls
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/dac22ab5392b42ceb89fdb2d04f1f6cf.png)

6.2 编译环境

```
docker-compose build
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/8826d479399247d19cac4368b5584a13.png)

6.3 运行环境

```
docker-compose up -d
```

6.4 查看端口

```
docker-compose ps
docker ps
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/99dbccec16e8460cb65771e03b010197.png)

6.5 查看ip

```
ip a
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/b864d9f810564857a93c5eb342240344.png)

6.6 宝塔面板放行端口

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/5398f901945340fb9f0531283655dd15.png)

6.7 访问靶场地址

```
http://192.168.110.198:8983
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/f19a24723ea74f90bfbd516c97ac17fc.png)

## 2.扫描log4J漏洞

### 1.log4Jshell扫描

1.访问nessus扫描网站

```
https://192.168.110.230:8834/#/
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/5312ef585b90494393ac1c3836733512.png)

2.登录后，点击【新增扫描】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/d7b219844c3d4be4a870a9172bd1a0c8.png)

3.选择【Log4Shell】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/879dab939e1948fe88055cce194c4472.png)

4.输入Name【log4jshell】，目标【192.168.110.198】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/2c9bafcb837e4b10acdfe1796110af16.png)

5.点击【发现】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/54e3442117ad4a51808430dcd3d9004a.png)

6.选择扫描类型【彻底】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/27cc3ab79bf54b9da3af319a2d8ed9ff.png)

7.点击【评估】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/249465aabe16419b9480bc51108f7922.png)

8.选择扫描类型【默认】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/1be69e69dc224a41bab404c4918e0e4f.png)

9.点击【证书】,点击【ssh】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/e39419bb80074bfc9a6f0173912c924d.png)

10.选择身份验证方法【密码】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/ae7649df348d424397281fcfb273e6d0.png)

11.输入被扫描服务器的用户名【root】，密码【root】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/20a706aa71c149f988c2bd3a0a8c91d1.png)

12.点击【插件】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/d55fa35e69ea42768a03f1513c35f1ef.png)

13.点击【保存】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/f9ea1593922343a58b2ce767e674cdf0.png)

14.执行【log4shell】扫描

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/d7721cd40f2d4817b55c50dccb64b0b5.png)

15.查看log4J的扫描结果

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/366adf34bbb8440ba60b270fdcf51d87.png)

### 2.nesuss扫描Log4Shell 漏洞生态系统

1.访问nessus扫描网站

https://192.168.110.230:8834/#/

2.点击新建扫描

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/3e85bf0e4380479b8df37afeb85973e5.png)

3.选择【Log4Shell 漏洞生态系统】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/24fc6288d71340efae4d97bd5ad9f870.png)

4.输入Name【log4jshell 生态】，目标【192.168.110.198】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/5fe55d20097c458db27204caad1b22af.png)

5.点击【发现】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/5b8e5e6b086742fe85a816475ef782bc.png)

6.选择扫描类型【彻底】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/525da2c8e3684e69a3e7ebde40302d61.png)

7.点击【评估】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/99012fc379dd4e27aec5c0a4e3f2c1f8.png)

8.选择扫描类型【默认】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/4ea0cce3414643abb0cce510e0b882b4.png)

9.点击【证书】,点击【ssh】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/7c20e6d3e7824e95ba02c85bc7722628.png)

10.点击【插件】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/741be19fc5044b4c84da53ecdf6bab9f.png)

11.点击【保存】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/5e45a982324f4b14a7c17e016f0c5b9f.png)

12.执行【log4shell 生态】扫描

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/fc08c461762b4f96aa936946747c4e05.png)

13.查看log4J 生态的扫描结果

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1648296056045/3192b68ad96e4e9aaaff70e36b057477.png)
