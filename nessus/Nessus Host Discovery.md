# Nessus Host Discovery

1.启动nessus

```
cd nessus
sh qd_nessus.sh
```

2.进入nessus网站

```
https://192.168.3.47:8834/
```

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/7ab2d5aa1c7a436d9a4236390971d873.png)

3.点击【New Scan】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/ae91d3e49a014ce4bf5d16e14d4c009a.png)

4.选择【Host Discovery】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/6314833fd6b24fc482bbf884bdeb3bd4.png)

5.输入name【主机发现】，Description【主机发现】，Targets【192.168.3.0/24】,点击【Save】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/9af5119ff47a41ef9f14fc1edd751799.png)

6.点击【 Schedule】

这里是配置定时任务的，可以忽略

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/32d9e17742fa4afb8942d1cf5db96ba6.png)

7.点击【 Notifications】

这里主要是配置邮件提醒的，可以配置也可以忽略

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/c65ec8c79ceb4e16a91630ce6bfcddf5.png)

8.点击【Discovery 】

这里选择常用端口扫描

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/7c9a0ee9cc2b48bfa166e80f991819c5.png)

9.点击【Report 】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/a768bfa493014b299c4cf4aca1346474.png)

10.点击【Advanced 】

这里是高级设置选项

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/07171ac22bdb481a97298199b7a36636.png)

11.点击【Plugins】

这里是配置插件的地方，主机发现不要配置插件

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/1b538e5621c64332a3ee06cd862080b0.png)

12.点击【保存】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/193ae3a3dbd145b88480bb71deb6e721.png)

13.点击【主机发现】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/2fe3b92bf40640bea04bc8ecbb12a487.png)

14.点击【More】，点击【Launch】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/7abedbdf5cb94f9faafa11eec2017cca.png)

15.点击【Launch】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/bda6368a8f0a48d5a42370ce5a7bf537.png)

16.点击【主机发现】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/de021dcff58f431c9ceee57cd0354fae.png)

17.查看扫描结果

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/a9678c7f935a4213bfdd401d11ed91ae.png)

18.选择其中一个主机查看

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/0a1af822d924498bb1c20ed9a3675b4e.png)

19.查看具体的扫描结果

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1762/1647250261071/c8b48d3a6f4241d6a9be2a6bf3b678e3.png)
