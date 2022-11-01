# 第三节-AWVS扫描Web应用程序

## 1.账户密码登录扫描

1.点击【Targets】，点击【add Target】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/36991ed7d4ba43f5aff2ed560749d35c.png)

2.输入扫描地址和扫描描述,点击【save】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/a92e61f1c3cf479ca7c04a8105bc617b.png)

3.点击【Site Login】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/cc6082a28000438fb243888a3b5327f5.png)

4.选择【try to auto-login into the site】,输入登录地址，用户名【xiaogang】，密码【123456】，重复密码【123456】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/4f5f3ed8e050454da04304dfbf077784.png)

5.点击【HTTP Authentication】的开启按钮

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/ca1b8fd89df143d8a32a114a9f971fa6.png)

6.输入用户名【小刚】,密码【123456】，重复密码【123456】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/02d9c182fc4a4aaf84186c293614aac5.png)

7.点击【save】，然后点击【Scan】按钮

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/d9df48791deb4782bf8e421cc69d64a8.png)

8.选择扫描设置，如图所示，点击【create Scan】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/4ebab4587a3a4abf81832bc4989c26ba.png)

9.点击扫描目标，查看扫描具体内容

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/9e11ed8ed6f24a76a46002b080400de5.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/5e96d1f03e154a0f822790fa2c0e68ec.png)

10.等待扫描完成

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/d78be9706759447580549e5988e03992.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/4d217c7e40e74a27b0ef45cc199e8164.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/c0a379d78ce840c8a7e53eb742c00063.png)

## 2.利用录制登录序列脚本扫描

1.点击【Targets】，点击【add Target】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/339ff784fc8a4afb9ff6764f19515ef6.png)

2.输入扫描地址和扫描描述,点击【save】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/776d1d5413c344f9b0971f516d601343.png)

3.点击【Site Login】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/7739d66d7aac4c5da0480d475773b3e8.png)

4.选择【Use pre-recorded login sequence 】,点击【New】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/994d395f718b45499787edd45a19b638.png)

5.点击【登录】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/c29d1e54000945b192df336e08c91347.png)

6.输入用户名【xiaogang】，密码【123456】,点击【登录】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/cc5e9e0302c54028812dacf84cb06860.png)

7.检查登录脚本流程是否完整，点击【Next】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/e62eec33761c4c2094454c341bb51095.png)

8.点击【xaiogang_vip3】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/387c0b1b3d4a4bdab0fd2ff9f7f63927.png)

9.点击【Restrict requests to path】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/fddbf7c1804e41548435d3528683d093.png)

10.点击【Next】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/ce0add0774944ffe9d8927a577cb2ef6.png)

11.点击【确定】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/98c4b3e7a6dc419eb47b7c7484cd2031.png)

12.点击【Finish】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/696267829a0b43fc9e85b95fca2d88f8.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/dc773606b84d4711bf43c4e6dc931ce0.png)

13.点击【Scan】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/485e9f63b9b04b54b4b0d167fcce6109.png)

14.选怎扫描配置，如下图所示，点击【Create Scan】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/1a594edc6fd04f2aa029c8bdd8243c61.png)

15.点击目标连接，查看具体扫描信息

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/dbb993767f214481b9d2e73f3edd6341.png)

16.等待扫描完成

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/03e6d16afaec4f48b73bfe009796c34f.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/fd0c824cc75d4e0daaed7d6d3aeeeb82.png)

## 3.利用定制cookie扫描

扫描过程会遇到网站 存在 手机验证码，图形验证码，滑动验证等等，这时候想要深度扫描时，就需要进行登录绕过。最长用的手段就是定制cookie绕过。

1.点击【Targets】，点击【add Target】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/773081aad11743e1afa80907ea1cee93.png)

2.输入扫描地址和扫描描述,点击【save】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/38cb04b93af647d8b728150d39621a16.png)

3.点击【Advanced】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/5825a551928b43219f0fc9af60192257.png)

4.点击【Custom Cookies】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/fcdc3b768b124c3facf16d1b48f6b501.png)

5.输入被测网站网址

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/b0275ea0dd1d40a08419dcb420fd0cc3.png)

6.切换到其他浏览器，获取网站的cookie值

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/152a0512b80e4849841a679a47a39523.png)

7.切换会AWVS，输入cookie的值，点击【+】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/649473f702434786b796dbc2d2c288fa.png)

8.点击【save】，然后点击【Scan】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/e4875f76ecdf4c018469b5a95a64c094.png)

9.设置扫描选项，如下图所示，点击【Create Scan】

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/5ffa52bd590e42048dfb0e8158b83211.png)

10.点击扫描的网站地址，查看扫描信息

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/4e18d51428f741c9a5e8da8cdda0f3c0.png)

11.等待扫描完成

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/1e36af11e5b14c9ca46f1f4bb1fd9ca0.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/1762/1642128985000/979340ee6370462da77cfb93f83b7407.png)
