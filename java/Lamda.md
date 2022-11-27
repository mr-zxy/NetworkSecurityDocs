# Lamda 表达式
1. 函数式接口定义
    * 任何接口，如果只包含一个抽象方法，那么他就是一个函数式接口。
    * 对于函数式接口，一般通过lamdba表达式来创建该接口。
    * 简化内部匿名类，通过接口调用。
    ``` java
    public interface RunDemo{
        public abstract void run();
    }
    ```
    ``` java
    interface Demo {
        void run(int n);
    }

    public class DemoImpl {
        public static void main(String[] args) {
            Demo demo1=(n)->{System.out.println("a"+n);};
            demo1.run(10);
            // 简化
            Demo demo2= n->System.out.println("b"+n);
            demo2.run(10);
        }
    }
    ```