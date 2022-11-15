## 常用属性
|属性|描述|
|---|----|
|id|在命名空间中唯一的标识符，被用来引用这条语句|
|parameterType|传入这条语句的参数的类全限定名或别名|
|resultType|期望从这条语句中返回结果的类全限定名或别名，resultType 和 resultMap 之间只能同时使用一个|
|resultMap|在命名空间中唯一的标识符，被用来引用这条语句 ，resultType 和 resultMap 之间只能同时使用一个|
|flushCache|将其设置为 true 后，只要语句被调用，都会导致本地缓存和二级缓存被清空，默认值：对于（select语句）false ；对于（ insert、update 和 delete 语句）true|
|useCache|将其设置为 true 后，将会导致本条语句的结果被二级缓存缓存起来，默认值：对于（select语句）为 true|
|useGeneratedKeys|（仅适用于 insert 和 update）这会令 MyBatis 使用 JDBC 的 getGeneratedKeys 方法来取出由数据库内部生成的主键（比如：像 MySQL 和 SQL Server 这样的关系型数据库管理系统的自动递增字段），默认值：false|
|keyProperty|（仅适用于 insert 和 update）指定能够唯一识别对象的属性，MyBatis 会使用 getGeneratedKeys 的返回值或 insert 语句的 selectKey 子元素设置它的值，默认值：未设置（unset）|

## sql 定义标签
|标签|描述|
|----|----|
|select|查询|
|insert|插入|
|update|数据更新|
|delete|删除数据|

## sql 动态标签
|标签|说明|
|----|----|
|if|单个条件判断，用以实现条件筛选。此处需要注意，如果参数值为数字int型，判断是否等于某个固定值时可能会导致判断失效，修改成.toString()<\if test="userFlag !=null and userFlag !='' and userFlag =='1'.toString()">|
|
|where|只会在子元素返回任何内容的情况下才插入 “WHERE” 子句，并且可以自动处理判断条件语句返回的第一个and或or，不使用where标签时，若userSex为空，语法错误会报错，会自动过滤掉第一个and|
|set|set 标签元素主要是用在更新操作的时候，它的主要功能和 where 标签元素其实是差不多的，主要是在包含的语句前输出一个 set，然后如果包含的语句是以逗号结束的话将会把该逗号忽略，如果 set 包含的内容为空的话则会出错。有了 set 元素就可以动态的更新那些修改了的字段。|
## set 补充
> 当 update 语句中没有使用 if 标签时，如果有一个参数为 null，都会导致错误。
当在 update 语句中使用if标签时，如果前面的if没有执行，则或导致逗号多余错误。使用set标签可以将动态的配置 SET 关键字，并剔除追加到条件末尾的任何不相关的逗号。使用 if+set 标签修改后，如果某项为 null 则不进行更新，而是保持数据库原值。如下示例：
```
<update id="updateUser_if_set" parameterType="com.pojo.User">  
    UPDATE user  
    <set>  
        <if test="username!= null and username != '' ">  
            username = #{username},  
        </if>  
        <if test="sex!= null and sex!= '' ">  
           sex = #{sex},  
        </if>  

        <if test="birthday != null ">  
            birthday = #{birthday},  
        </if>  
    </set>  
    WHERE user_id = #{userid};      
</update>  
```
## 1. resultMap
> SQL返回与实体类映射关系信息，例：把name字段映射成id
``` shell
<select id="read" parameterType="com.system.domain.SysUserDomain" resultMap="OrderResultMap">
        select * from car_hailing.user
        <where>
            <if test="name!=null and name!=''">
                and name like concat('%',#{name},'%')
            </if>
        </where>
    </select>

    <resultMap id="OrderResultMap" type="com.system.domain.SysUserDomain">
        <id column="id" property="id"/>
        <result column="id" property="name"/>
    </resultMap>
```
## 2. sql
> 用于定义可重用的 SQL 代码片段，以便在多个SQL语句中使用。 参数可以静态地（在加载的时候）确定下来，并且可以在不同的 include 元素中定义不同的参数值。例：把id age 动态添加进去
``` shell
<sql id="userColumns">${alias},name,${alias}</sql>
    <select id="read" parameterType="com.system.domain.SysUserDomain" resultType="com.system.domain.SysUserDomain">
        select
        <include refid="userColumns"><property name="alias" value="id"/></include>,
        <include refid="userColumns"><property name="alias" value="age"/></include>
        from car_hailing.user
        <where>
            <if test="name!=null and name!=''">
                and name like concat('%',#{name},'%')
            </if>
        </where>
    </select>
```
## 3. foreach 
> 用于更新或保存数据时的批量操作，例：批量添加
``` shell
<insert id="createAll" parameterType="List">
        insert into car_hailing.user(
        id,
        name,
        age
        )values
        <foreach item="item" index="index" collection="list" separator=",">
            (
            #{item.id},
            #{item.name},
            #{item.age}
            )
        </foreach>
    </insert>
```
## 4. 3. choose/when/otherwise
> 用以实现条件的多种判断，类似与if else，例：


