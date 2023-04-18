## shadowsocks
> 节点搭建
* Vps 购买 https://www.vultr.com/register/
> 安装shadowsocks：
* apt install shadowsocks-libev
1. 查看shadowsocks状态：
* systemctl status shadowsocks-libev.service
2. 编辑ss配置文件：
* vim /etc/shadowsocks-libev/config.json 
    * server 改成 0.0.0.0
3. 重启shadowsocks：
* systemctl restart shadowsocks-libev.service
4. 查看shadowsocks运行日志：
* journalctl -u shadowsocks-libev.service -f    
5. 端口 8388
6. 防火墙开放端口
> 防火墙设置：
```
查看状态：ufw status
开放端口：ufw allow 8388
拒绝端口：ufw deny 8388
删除规则：ufw delete allow 8388
关闭防火墙：ufw disable
启动防火墙：ufw enable
```
> ss协议 添加plugins 插件 防止长城防火墙重放 数据会被加密，绕过防火墙
1. github https://github.com/shadowsocks/v2ray-plugin
2. 安装 apt install shadowsocks-v2ray-plugin
3. 查看包内容 dpkg -L shadowsocks-v2ray-plugin 
4. 配置 /etc/shadowsocks-libev/config.json 按照github配置：！！！注意 plugin-opts 改为 plugin_opts
5. 重启
> 客户端 配置插件
1. shadowsockets 下载工具
2. v2ray plugin 客户端下载 https://github.com/shadowsocks/v2ray-plugin/releases
> 总结 
    * 配置插件麻烦，不配置插件伪装不好，容易被封杀ip。
    * 如果 第一次可以科学上网，之后不行。把ss的端口换了。
---

