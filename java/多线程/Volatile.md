# Volatile 例子
>  1、两个线程访问共享变量时，值不同步（线程一需等待线程二数据准备好之后再执行业务逻辑，实际却是线程一死循环了）
``` java
public class Volatile {
    private volatile static boolean initFlag = false;//共享变量
    public static void main(String[] args) throws InterruptedException {
        //做业务的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("等待数据。。。。");
                while (!initFlag){
                }
                System.out.println("工作完成了");
            }
        }).start();
        //保证第一个线程先执行
        Thread.sleep(2000);
        //准备数据的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始准备数据。。。");
                initFlag = true;
                System.out.println("数据准备完毕。。。");
            }
        }).start();
    }
}
```