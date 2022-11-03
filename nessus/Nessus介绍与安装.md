# Nessus介绍与安装

## 1.Nessus简介

Nessus号称是世界上最流行的漏洞扫描程序，全世界有超过75000个组织在使用它。该工具提供完整的电脑漏洞扫描服务，并随时更新其漏洞数据库。Nessus不同于传统的漏洞扫描软件，Nessus可同时在本机或远端上遥控，进行系统的漏洞分析扫描。Nessus也是渗透测试重要工具之一

## 2.kali安装Nessus

1.访问Nessus官网

```
https://www.tenable.com/downloads/nessus
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1646044171048/1dde7c7b4ec645cba3c61b1e8a5ca73f.png)

或者下载课程资料里的安装包【Nessus-10.1.1-debian6_amd64.deb】到kali

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1646044171048/22505ff746a648c397bf5dc2cef5a7a2.png)

2.安装Nessus程序

```
dpkg -i Nessus-10.1.1-debian6_amd64.deb 
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1646044171048/071d1f15c17c42f381975763adf711d0.png)

You can start Nessus Scanner by typing /bin/systemctl start nessusd.service 启动服务命令

Then go to [https://kali:8834/](https://kali:8834/) to configure your scanner  访问地址

3.启动Nessus

```
service nessusd start
```

4.查看kali的ip

```
ip a
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1646044171048/f892a26fccf8481fa9f5f687c26c1a58.png)

5.浏览器访问nessus的web网站

```
https://192.168.11.75:8834/#/
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1646044171048/d7e0366737ee4e91b5e16b403792ae4b.png)

6.选择 【Managed Scanner】选项，点击【Continue】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1646044171048/f8c1d51f75694259b6a4cd4ce504dfea.png)

7.选择【Tenable.sc】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1646044171048/80ba631a892e4a089673aedb0df08804.png)

8.点击【Continue】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1646044171048/3f4f08d4a8544277ae02f174a8e62ecc.png)

9.输入用户名【admin】，输入密码【123456】，点击【Submit】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1646044171048/8021cf24bd45404eaeba0b0fae793bd5.png)

10.等待配置插件

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1646044171048/86313f9a1137476c8a1a0d023c89069b.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1646044171048/565d98fe895c431eb8504e1814f9403d.png)

安装完成后是这样的界面,尚未激活,不能扫描,此时只有一个设置按钮,并无扫描按钮.

## 3.离线激活Nessus

1. 去nessus官方申请激活码，姓名随便填，邮箱必须正确，用来接收激活码

```
https://zh-cn.tenable.com/products/nessus/nessus-essentials
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/2e042a1b3bc24ebe96668f68b6ccd487.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/b89303b62eee43bc99b9d7c3739212f2.png)

2.进入填写的邮箱获取激活码

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/9b2d9202c94c4da080936d485a3c2c83.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/24bf49a1d16e4261a1d30d92ec805d5b.png)

3.获得质询码（challenge code）

```
/opt/nessus/sbin/nessuscli fetch  --challenge
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/97008ee858754d229d82981cc26b7a62.png)

4.获取离线插件包地址及激活证书

浏览器打开网页 [https://plugins.nessus.org/v2/offline.php](https://plugins.nessus.org/v2/offline.php) ，输入申请的激活码，以及上一步得到的质询码，点击【Submit】

```
https://plugins.nessus.org/v2/offline.php
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/dad3f4a3b1804e7e88742ace5246b2f2.png)

5.得到更新插件地址，及license证书

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/c2f6d9b61f25438c838edc005ac099cc.png)

6.下载更新包，下载证书nessus.license。

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/045c0b7dccda4006a172bbe12979e312.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/9788ef99b5ce4621ae1e644285f43ed2.png)

7.将下载好的激活证书和插件包复制到kali

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/4f9d3d443be24573a4e003cdad62294d.png)

8.离线激活nessus

```
/opt/nessus/sbin/nessuscli fetch --register-offline ./nessus.license
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/4da74bfab4124d49824c08fabcfbb02f.png)

您的激活码已正确注册-谢谢。

9.安装插件包

```
/opt/nessus/sbin/nessuscli update ./all-2.0.tar.gz

/opt/nessus/lib/nessus/plugins/  #插件包目录
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/3602dbf8e98c41b08e2698986e81f194.png)

10.重启nessus

```
service nessusd restart
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/2f8e50f756dd4a4797a7e0f9bc2213fa.png)

11.重新访问nessus网站，等待加载插件【耗时较长,需要耐心等待】

```
https://192.168.10.141:8834/#/settings/about
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/9b16c2d94b5d4440b025297ec1f9b6f5.png)

完成后进入nessus系统。显示激活成功，具有了scan功能。但显示仅允许扫描16个IP。

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/b2def339468746fdbd114bed1f43d1d3.png)

## 4.解除IP限制

1.获取当前plugins的版本。

```
https://plugins.nessus.org/v2/plugins.php
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/3032df10296340a5bcba5e1d51445822.png)

2.停止nessus服务

```
service nessusd stop
```

3.创建 plugin_feed_info.inc

```
vi plugin_feed_info.inc
```

内容如下，并将刚刚获取到的版本号替换如下内容中的数字串。

```
PLUGIN_SET = "202203090609";
PLUGIN_FEED = "ProfessionalFeed (Direct)";
PLUGIN_FEED_TRANSPORT = "Tenable Network Security Lightning";
```

4.将plugin_feed_info.inc替换到 /opt/nessus/var/nessus/plugin_feed_info.inc

```
cp plugin_feed_info.inc /opt/nessus/var/nessus/
```

5.将 /opt/nessus/lib/nessus/plugins/plugin_feed_info.inc 文件删除。

```
rm -rf /opt/nessus/lib/nessus/plugins/plugin_feed_info.inc
```

6.启动nessus服务

```
service nessusd start
```

7.访问Nessus，windows打开浏览器，访问nessus，会看到nessus初始化插件，完成后，看设置页面显示 unlimited。表示解除IP限制成功。

```
https://192.168.3.47:8834/
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/be568c6057e74ea59f2f4a61bbad1fd2.png)

## 5.解决Nessus重启失效后遗症

由于Nessus服务每次重启后，都会重置plugin_feed_info.inc，这将会使nessus/plugins目录下所有的插件都被删除，无法扫描。因此要将nessus服务设置为手动，并且先停止nessus服务。可以写成批处理解决此问题

1.编写启动脚本

```
vi qd_nessus.sh

service nessusd stop;
cp /root/nessus/plugin_feed_info.inc /opt/nessus/var/nessus/;
rm -rf /opt/nessus/lib/nessus/plugins/plugin_feed_info.inc;
service nessusd start;
```

每次需要启动nessus时 输入启动命令

```
sh /root/nessus/qd_nessus.sh
```

2.nessus命令合集

```
#启动
service nessusd start;
#重启
service nessusd restart;
#查看状态
service nessusd status
#停止服务
service nessusd stop
```

3.遇到的坑及相应的解决办法

在解除ip限制的过程中，如果已经解除成功，但是新建扫描项目时，发现很快就结束，无扫描结果。此时查看plugins目录内容是否被删除。

```
du -h /opt/nessus/lib/nessus/plugins
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1646044171048/e89f232f79234dfabfe2419db15ac273.png)

正常情况下，该目录应该在1.4G左右。如远远低于此数值。请按如下步骤操作：

```
service nessusd stop;
/opt/nessus/sbin/nessuscli update ./all-2.0.tar.gz
sh qd_nessus.sh
```

然后打开浏览器，正常访问nessus。（[https://](https://links.jianshu.com/go?to=https%3A%2F%2Fcentos)ip:8843）静待plugins更新完成。
