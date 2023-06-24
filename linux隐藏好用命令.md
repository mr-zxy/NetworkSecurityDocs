## linxu 命令 不包括基础
* ssh root@8.140.182.127 连接服务器
* rz 打开上传文件终端
* cat /proc/cpuinfo linux查看cpu信息
* whereis [-bm] name whereis命令仅搜索特定类型的文件：二进制可执行文件、说明文档、源文件和其他特殊文件 例如 whereis nginx
* locate [-irc] name 命令在一个数据库中通过文件名查找文件，所以其查找速度很快。 返回路径下所有信息
* chomd 777 name 文件设置可读可写
* df -h / fdisk -l 查看硬盘
* whoami / id 查看用户
* useradd 用户名 创建用户
* passwd 密码 设置密码
* cat /etc/passwd 查看所有用户
* sudo install -c -o $USER xxx /usr/local/bin/ 将可执行文件添加到系统中在任何位置可使用