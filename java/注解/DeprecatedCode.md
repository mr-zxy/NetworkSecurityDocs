```java
public class Test  {
    @Deprecated
    public void run() {
        System.out.println("重写父级");
    }
}

class Test1{
    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }
}
```