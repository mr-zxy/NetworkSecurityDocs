# linux 基础命令
### java jar包启动错误日志输出
```
java java -jar ./docker-0.0.1-SNAPSHOT.jar >> ./register.log 2>&1 &
```
### ls
```shell
‘d’：目录文件；
‘-’：普通文件；
‘p’：管理文件；
‘l’：链接文件；
‘b’：块设备文件；
’c‘：字符设备文件；
‘s’：套接字文件。
```
### uname  查看版本
```
1. -a 
    * 3.10.0-1127.19.1.el7.x86_64 #1 SMP Tue Aug 25 17:23:54 UTC 2020 x86_64 x86_64 x86_64 GNU/Linux
```
### grep常用用法  grep [-acinv] [--color=auto] '搜寻字符串' filename
``` shell
选项与参数：
-a ：将 binary 文件以 text 文件的方式搜寻数据
-c ：计算找到 '搜寻字符串' 的次数
-i ：忽略大小写的不同，所以大小写视为相同
-n ：顺便输出行号
-v ：反向选择，亦即显示出没有 '搜寻字符串' 内容的那一行！
--color=auto ：可以将找到的关键词部分加上颜色的显示喔
```
### scp 文件服务
   ```
    1. 从本地将文件传输到服务器 
        * scp【本地文件的路径】【服务器用户名】@【服务器地址】：【服务器上存放文件的路径】
        * scp /Users/mac_pc/Desktop/test.png root@192.168.1.1:/root 
    2. 从本地将文件夹传输到服务器 
        * scp -r【本地文件的路径】【服务器用户名】@【服务器地址】：【服务器上存放文件的路径】
        * scp -r /Users/mac_pc/Desktop/test root@192.168.1.1:/root
    3. 将服务器上的文件传输到本地 
        * scp 【服务器用户名】@【服务器地址】：【服务器上存放文件的路径】【本地文件的路径】
        * scp root@192.168.1.1:/data/wwwroot/default/111.png /Users/mac_pc/Desktop
    4. 将服务器上的文件夹传输到本地 
        * scp -r 【服务器用户名】@【服务器地址】：【服务器上存放文件的路径】【本地文件的路径】
        * scp -r root@192.168.1.1:/data/wwwroot/default/test /Users/mac_pc/Desktop 
   ```
###  netstat：查看网络状态 
```shell
    * -r显示路由表信息，功能类似前面学过的route和ip route
　　* -g显示多播功能群组成员，功能类似前面学过的ip maddr
　　* -i显示网络接口信息，功能类似前面学过的ip -s link
　　* -s显示各类协议的统计信息
　　* -n显示数字形式地址而不是去解析主机、端口或用户名。默认情况下netstat命令会尝试解析并显示主机的主机名，这个过程通常比较长也是非必需的※
　　* -a显示处于监听状态和非监听状态的socket信息※
组合使用
    1. netstat -an 常用组合-a和-n，显示所有连接信息
    2. netstat -lntup 显示所有TCP和UDP正在监听的连接信息。 
        * -l：显示所有LISTEN状态的网络连接。
　　    * -n：显示IP地址，不进行DNS解析成主机名、域名。
　　    * -t：显示所有TCP连接。
　　    * -u：显示所有UDP连接。
    3. netstat -rn 显示当前系统的路由表
        * 使用-r选项显示路由表信息
        * -n选项不进行DNS解析，加快命令执行速度
        ** 该命令相当于route -n
    4. netstat -i -i显示网络接口状况
        * Iface表示网络设备的接口名称。
        * MTU表示最大传输单元，单位字节。
        * RX-OK/TX-OK表示已经准确无误地接收/发送了多少数据包。
        * RX-ERR/TX-ERR表示接收/发送数据包时产生了多少错误。
        * RX-DRP/TX-DRP表示接收/发送数据包时丢弃了多少数据包。
        * RX-OVR/TX-OVR表示由于误差而遗失了多少数据包。
        * Flg 表示接口标记，其中：
        * L：表示该接口是个回环设备。
        * B：表示设置了广播地址。
        * M：表示接收所有数据包。
        * R：表示接口正在运行。
        * U：表示接口处于活动状态。
        * O：表示在该接口上禁用 arp。
        * P：表示一个点到点的连接。
　　    ** 正常情况下，RX-ERR/TX-ERR、RX-DRP/TX-DRP和RX-OVR/TX-OVR的值都应该为0，如果这几个选项的值不为0，并且很大，那么网络质量肯定有问题，网络传输性能也一定会下降
```
###  lsof -i tcp:8080  查看端口进程
### kill PID 杀死进程

