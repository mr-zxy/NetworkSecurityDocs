# synchronized
> synchronized 方法在被调用时自动执行锁定操作；在锁定操作成功完成之前，不会执行其主体。如果该方法是一个实例方法，那么它将锁定与被调用它的实例关联的监视器（即，在执行方法主体期间将被称为 this 的对象）。
```java
public class MyThread6_1 implements Runnable {

    private int count = 5;

    // 锁方法体
    private synchronized void run1(){
        count--;
        System.out.println("由 " + Thread.currentThread().getName() +
                " 计算, count=" + count);
    }
    // 锁代码块
    // private void run1(){
    //     synchronized(this){
    //         count--;
    //         System.out.println("由 " + Thread.currentThread().getName() +
    //                 " 计算, count=" + count);
    //     }
    // }
    @Override
    public void run() {
        run1();
    }

    public static void main(String[] args) {
        MyThread6_1 thread = new MyThread6_1();
        // 5个线程共同调用线程 Thread6_1，同时共同修改变量 count
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        Thread t3 = new Thread(thread);
        Thread t4 = new Thread(thread);
        Thread t5 = new Thread(thread);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}


```