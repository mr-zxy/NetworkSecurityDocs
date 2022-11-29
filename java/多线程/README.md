# 开干
## 创建线程
1. 线程创建方式一 集成Thread类，重写run() 方法，调用start开启线程
* 注意：线程开一不一定要立即执行，由cpu调度执行
2. 线程创建方式一 实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法。
* 启动：传入目标对象+Thread对象.start() 
* 推荐使用：避免单继承的局限性，灵活方柏霓，方便同一个对象被多个线程使用
1. callable 重写call方法
    ``` shell
    ExecutorService ser= Executors.newFixedThreadPool(10);   // 创建执行服务
    Future<Boolean> r1=ser.submit(threadCallable); //            提交执行
    Boolean rs1=r1.get(); // 获获取结果
    ser.shutdownNow(); // 关闭服务
    ```

## 线程方法
1. sleep(1000) 线程延时 不会释放锁
2. yield  线程礼让
3. join 线程插队
4. thread.getState() 获取线程运行状态
5. setPriority getPriority 设置/获取线程优先级 优先级只是意味获取调度的概率低，并不是优先级低就就不被调用，这都是要看cpu的调度
6. setDaemon 守护进程当所有常规线程运行完毕以后，守护线程不管运行到哪里，虚拟机都会退出运行。
## 线程状态
1. NEW 尚未启动的线程在此状态
2. RUNNABLE 在java虚拟机中执行的线程出于状态
3. BLOCKED 被粗赛等待监视器锁定的线程处于状态
4. WAITING 正在等待另一个线程执行特定动作的线程处于状态
5. TIMED_WAITING 正在等待另一个县城执行动作达到指定等待时间的线程处于状态
6. TERMINATED 已退出的线程处于此状态
## 线程数据紊乱
1. synchronized 加锁 支持 代码块 方法 静态类
2. ReentrantLock 可重复锁
    * lock.lock(); 加锁
    * lock.unlock(); 解锁 一般放在 finally 里面

## 线程池
1. ExecutorService service= Executors.newFixedThreadPool(4); 创建线程池
2. service.execute(new MyPool()); 执行线程
3. service.shutdownNow(); 关闭线程

## Java多线程学习之wait、notify/notifyAll 详解
``` java
1、wait()、notify/notifyAll() 方法是Object的本地final方法，无法被重写。
2、wait()使当前线程阻塞，前提是 必须先获得锁，一般配合synchronized 关键字使用，即，一般在synchronized 同步代码块里使用 wait()、notify/notifyAll() 方法。
3、 由于 wait()、notify/notifyAll() 在synchronized 代码块执行，说明当前线程一定是获取了锁的。
当线程执行wait()方法时候，会释放当前的锁，然后让出CPU，进入等待状态。
只有当 notify/notifyAll() 被执行时候，才会唤醒一个或多个正处于等待状态的线程，然后继续往下执行，直到执行完synchronized 代码块的代码或是中途遇到wait() ，再次释放锁。
也就是说，notify/notifyAll() 的执行只是唤醒沉睡的线程，而不会立即释放锁，锁的释放要看代码块的具体执行情况。所以在编程中，尽量在使用了notify/notifyAll() 后立即退出临界区，以唤醒其他线程  
4、wait() 需要被try catch包围，中断也可以使wait等待的线程唤醒。
5、notify 和wait 的顺序不能错，如果A线程先执行notify方法，B线程在执行wait方法，那么B线程是无法被唤醒的。
6、notify 和 notifyAll的区别
notify方法只唤醒一个等待（对象的）线程并使该线程开始执行。所以如果有多个线程等待一个对象，这个方法只会唤醒其中一个线程，选择哪个线程取决于操作系统对多线程管理的实现。notifyAll 会唤醒所有等待(对象的)线程，尽管哪一个线程将会第一个处理取决于操作系统的实现。如果当前情况下有多个线程需要被唤醒，推荐使用notifyAll 方法。比如在生产者-消费者里面的使用，每次都需要唤醒所有的消费者或是生产者，以判断程序是否可以继续往下执行。
7、在多线程中要测试某个条件的变化，使用if 还是while？
　　要注意，notify唤醒沉睡的线程后，线程会接着上次的执行继续往下执行。所以在进行条件判断时候，可以先把 wait 语句忽略不计来进行考虑，显然，要确保程序一定要执行，并且要保证程序直到满足一定的条件再执行，要使用while来执行，以确保条件满足和一定执行
```
[Java多线程学习之wait、notify/notifyAll 详解 参考链接](https://blog.csdn.net/weixin_30827565/article/details/97787238?spm=1001.2101.3001.6650.4&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-4-97787238-blog-82905577.pc_relevant_multi_platform_whitelistv4&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-4-97787238-blog-82905577.pc_relevant_multi_platform_whitelistv4&utm_relevant_index=9)