# cmd 常见指令
```bat
cd // 进入目录
cd .. // 退目录
dir // 遍历当前路径下所有文件
ipconfig // 查询本机ip信息
cls // 清屏
type // 读文件内容
color a // 修改字体颜色
title // 修改标题
findstr // 过滤关键字
net user // 查看本地用户
net user admin 208522 /add // 添加用户
net user admin /del // 删除用户
net view // 显示域列表
arp -a // 查看arp缓存表
ping // 测试网络通信命令
route print // 显示路由
tracert // 路由追踪
netstat // 显示网络连接
shutdown -s -t 60 // 一分钟后关机
shutdown -a // 取消关机计划
shutdown -l // 注销计算机
logoff // 注销计算机
tasklist // 列出正在运行的进程
taskkill // 终止进程
chkdsk // 检查磁盘,默认为C盘
nslookup // 查询网站ip地址
echo 你好 > new.txt // 新建文件
del flie.txt // 删除文件
rd flie // 删除文件夹
rd flie /s // 删除flie文件夹下的所有文件
dir /s // 显示当前目录及子文件
dir /d // 显示文件以及文件大小、个数
dir /b // 显示文件
tree // 生成目录树
copy 路径\文件名 路径\文件名 // 复制文件
move 路径\文件名 路径\文件名 // 移动文件
taskmgr // 启动任务管理器
notepad // 打开记事本
calc // 打开计算器
control // 打开控制面板
gpedit.msc // 打开组策略
regedit // 打开注册表编辑器
appwiz.cpl // 程序和功能
explorer // 打开资源管理器
inetcpl.cpl // Internet属性
main.cpl // 鼠标属性
magnify // 放大镜实用程序
mspaint // 画图
osk // 打开屏幕键盘
rstrui // 系统还原
write // 写字板
powercfg.cpl // 电源选项
netcpl.cpl // Internet属性
exit // 退出cmd

网络命令中最重要的，功能太强大。
子命令很多，例如：net use、net start、net stop等。
net start ：查看开启了哪些服务
net start 服务名：开启服务；
net stop 服务名 ：停止某服务
net config ：显示系统网络设置
net logoff ：断开连接的共享
net pause 服务名 ：暂停某服务
net send ip： “文本信息” 向对方发信息
net ver ：局域网内正在使用的网络连接类型和信息
net share ：查看本地开启的共享
net user 用户名 密码： 将用户登陆后将密码改为12345
net password 密码 ：更改系统登陆密码

netsh wlan show networks mode=bssid // 获取wifi信息
```
# 快捷指令
```bat
win+E 打开文件管器
win+D 显示桌面
win+L 锁计算机
alt+F4 关闭当前程序\文件
ctrl+shift+Esc 打开任务管理器（或者ctrl+alt+delete）
ctrl+F 在一个文本或者网页里面查找，相当实用（退出一般按ESC）
ctrl+A 选中所有文本,或所有文件
crtl+alt+tab 选中窗口但不打开，使用回车打开。按tab或←→切换
alt+tab 选中窗口并打开
win+tab 任务视图
ctrl+tab 切换窗口(仅同一软件内多个窗口有效，如浏览器开了许多个网页)
win + + 打开放大镜
```