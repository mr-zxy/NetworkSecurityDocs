1. 三大规式
    * 字段具有原子性，不可再分
    * 满足第一范式，每行应该被唯一区分，加一列存放每一行的唯一标识符（就是添加主键id）
    * 满足一二范式，且一个表不应包含其他表已存在的非主键信息（不简介依赖-不存在其他表的非主键信息）
    * * 优点
        * 重复冗余数据少，更新快，修改少。
        * 因为一个表不存在冗余重复数据，查询可能会造成多次关联，效率降低
2. MyISAM与InnoDB区别
    * InnoDB 聚集索引
    * MyISAM 非聚集索引
    
    