## WLAN 
	```shell
    172.20.10.2 自己手机热点
	192.168.1.29 家里
    ```
1. 远程连接下载 sudo apt-get install xrdp
2. sudo raspi-config 命令行启动配置
3. vnc 配置 
    * 重复 2步：选择interface config nvc 开启
    * 客户端官网 https://www.realvnc.com/en/
4. pinout 查看板载编码
5. gpio readall 全部编码 
*  报错查看 
    * cd /tmp
    * https://blog.csdn.net/qq_46919160/article/details/122069804
6. sudo shutdown -h now 关机 or halt