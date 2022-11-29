# ArrayList 线程不安全
1. 代码1：如果去掉 Thread.sleep(1000); 也会出现 arrayList size 不是5000的情况。原因。
    1. 加上Thread.sleep()有时候也会存在存在问题。延时过了，线程还没执行完，导致主线程执行了。
    2. 线程太慢还没执行完成，但是主线程执行完成了 
    3. 可能很多线程同时添加了list同一个位置，加上synchronized可以解决。
```java
public class AsyncList {
    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j <20 ; j++) {
            List arrayList = new ArrayList<>();
            for (int i = 0; i < 5000; i++) {
                int finalI = i;
                new Thread(() -> {
                    synchronized (arrayList) {
                        arrayList.add(finalI);
                    }
                }).start();
            };
            Thread.sleep(1000);
            System.out.println(arrayList.size());
        }
    }
}
```
2. 解决第一步 配合 CountDownLatch 解决
    > CountDownLatch的作用很简单，就是一个或者一组线程在开始执行操作之前，必须要等到其他线程执行完才可以。
    *  CountDownLatch countDownLatch = new CountDownLatch(5000); 声明有多少个线程
    * countDownLatch.countDown() 每次减去一个计数器
    * countDownLatch.await() 等待所有计数器执行完成
    * countDownLatch.await(1000, TimeUnit.MILLISECONDS) 带超时时间的await
    * countDownLatch.getCount() 获取计数器的值
    > 缺点：CountDownLatch 只能初始化一次，当CountDownLatch使用完毕后不能再次被使用。
``` java
public class AsyncList {
    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j <20 ; j++) {
            List arrayList = new ArrayList<>();
            CountDownLatch countDownLatch = new CountDownLatch(5000);
            for (int i = 0; i < 5000; i++) {
                int finalI = i;
                new Thread(() -> {
                    synchronized (arrayList) {
                        arrayList.add(finalI);
                        countDownLatch.countDown();
                    }
                }).start();
            };
            countDownLatch.await();
            System.out.println(arrayList.size());
        }

    }
}
```
3. CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>(); 替换 List arrayList = new ArrayList<>();
    * 但同样会存在执行太慢，导致主线程先执行。size() 不对问题，也需要配合countDownLatch 使用 
    * 不需要添加 synchronized 
    * 线程是安全的
``` java 
  public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 20; j++) {
            CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
            for (int i = 0; i < 10000; i++) {
                int finalI = i;
                new Thread(()->{
                    list.add(String.valueOf(finalI));
                }).start();
            }
            Thread.sleep(1000); // 模拟主线程后执行
            System.out.println(list.size());
        }
    }
```