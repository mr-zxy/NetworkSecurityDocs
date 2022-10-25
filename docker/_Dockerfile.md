# Dockerfile 常用配置说明
1. FROM
    * 功能为指定基础镜像，并且必须是第一条指令。
2. RUN
    * 功能为运行指定的命令 （和 CMD 区别 RUN 运行时执行，CMD 执行时执行）
3. WORKDIR
    * WORKDIR指令为Dockerfile中的任何RUN、CMD、ENTRYPOINT、COPY和ADD指令设置工作目录。如果WORKDIR不存在，它将被创建，即使它没有在任何后续Dockerfile指令中使用。
4. COPY
    * COPY的只能是本地文件
5. VOLUME 
    * 用于在image中创建一个挂载目录，以挂载宿主机上的目录
6. EXPOSE
    * 暴露端口
7. ENV
    * 设置环境变量 
        ``` dockerfile
        ENV <key> <value>
        ```
8. CMD
    * 功能为容器启动时要运行的命令
9. ENTRYPOINT
    * 功能是启动时的默认命令
    ```
    与CMD比较说明（这俩命令太像了，而且还可以配合使用）：
    1. 相同点：只能写一条，如果写了多条，那么只有最后一条生效容器启动时才运行，运行时机相同
    2. 不同点：
    ENTRYPOINT不会被运行的command覆盖，而CMD则会被覆盖
    如果我们在Dockerfile种同时写了ENTRYPOINT和CMD，并且CMD指令不是一个完整的可执行命令，那么CMD指定的内容将会作为ENTRYPOINT的参数
    ```
