# shell 语法学习
## for 循环
``` shell
for i in  {1..5} 
do
    echo $i
done
```
## if 判断
``` shell
if [ $1 -eq 1 ];
    then 
        echo "then1"
elif [ $1 -eq 2 ];
    then 
        echo "then2"
else 
        echo "else"
fi
```
## function  函数定义
``` shell
# 两和相加
function fn(){
    read -p "请输入第一个数字！" n1
    read -p "请输入第二个数字！" n2
    echo $[ $n1 + $n2 ] 
    return 0
}
#  函数赋值
result=$(fn) 
echo $result
```

