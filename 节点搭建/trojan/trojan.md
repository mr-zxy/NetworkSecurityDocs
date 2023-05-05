# Trojan-Go的的首要目标是保障传输安全性和隐蔽性。在此前提下，尽可能提升传输性能和易用性。
1. github https://github.com/p4gefau1t/trojan-go
2.1. 选择 trojan-go-linux-amd64.zip 手动解压 ./trojan-go 启动
2. trojan-go官方文档：https://p4gefau1t.github.io/trojan-go/
3. 创建配置文件 config.json
4. 证书申请
5. 端口 443
6. 防火墙开放端口
7. nohup ./trojan-go > log.log 2>&1 & 不间断 后台运行
```
申请证书：
    安装acme：curl https://get.acme.sh | sh
    安装socat：apt install socat
    添加软链接：ln -s  /root/.acme.sh/acme.sh /usr/local/bin/acme.sh
    注册账号： acme.sh --register-account -m my@example.com
    开放80端口：ufw allow 80
    申请证书： acme.sh  --issue -d 你的域名  --standalone -k ec-256
    安装证书： acme.sh --installcert -d 你的域名 --ecc  --key-file   /root/trojan/server.key   --fullchain-file /root/trojan/server.crt 
 
    如果默认CA无法颁发，则可以切换下列CA：
    切换 Let’s Encrypt：acme.sh --set-default-ca --server letsencrypt
    切换 Buypass：acme.sh --set-default-ca --server buypass
    切换 ZeroSSL：acme.sh --set-default-ca --server zerossl
```

// 本地替换
acme.sh --register-account -m 1989429861@qq.com
acme.sh  --issue -d leisurely.cc  --standalone -k ec-256
acme.sh --installcert -d leisurely.cc --ecc  --key-file   /trojan/server.key   --fullchain-file /trojan/server.crt 

acme.sh  --issue -d shoppping.top  --standalone -k ec-256
acme.sh --installcert -d shoppping.top --ecc  --key-file   /cer/server.key   --fullchain-file /cer/server.crt 