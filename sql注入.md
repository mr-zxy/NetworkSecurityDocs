
## sql 注入类型 工具 sqlmap
    boolean-based blind 基于Boolean的盲注
    time-based blind 基于时间的盲注error-based 基于报错
    UNION query-based 基于联合查询
    stacked queries 基于多条SQL语句（堆叠注入）
    out-of-band（OOB） 非应用内通信注入，比如DNSLog
## mysql 基本操作
    user dvwa
    password password
    SHOW DATABASES; 查看数据库
    shwo tables; 查看表
    SHOW COLUMNS FROM sys_user 查询列
    SELECT DATABASE(); 查询数据库名称
    SELECT USER();
    SELECT version();
    SELECT area_id FROM t_area ORDER BY area_id ASC  排序
    UNION  SELECT * FROM sys_user WHERE user_id="1" UNION SELECT * FROM sys_user WHERE account="liugp" 两条语句用于连接
    SELECT GROUP_CONCAT(account) FROM sys_user  字符拼接成一行
    SELECT if(1=1,1,2)  三元判断
    select sleep(1) 延迟执行