[公平锁非公平 参考链接](https://blog.csdn.net/tainxu/article/details/104418966?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-104418966-blog-118704070.pc_relevant_3mothn_strategy_recovery&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-104418966-blog-118704070.pc_relevant_3mothn_strategy_recovery&utm_relevant_index=2)
> Synchronized和Lock的区别
``` java
1.synchronized是一个关键字而lock是一个接口（lock、lockInterruptibly、tryLock、unlock、newCondition）。
2.synchronized是隐式的加锁，lock是显示的加锁。
3.synchronized可以作用在方法和代码块上，而lock只能作用在代码块上。
synchronized作用在静态方法上锁的是当前类的class，作用在普通方法上锁的是当前类的对象。
在javap反编译成字节码后，synchronized关键字需要有一个代码块进入的点monitorenter，代码块退出和代码块异常的出口点monitorexit。
4.synchronized是阻塞式加锁，而lock中的trylock支持非阻塞式加锁。
5.synchronized没有超时机制，而lock中的trylcok可以支持超时机制。
6.synchronized不可中断，而lock中的lockInterruptibly可中断的获取锁。（ReentrantLock.lockInterruptibly允许在等待时由其它线程调用等待线程的Thread.interrupt方法来中断等待线程的等待而直接返回，这时不用获取锁，而会抛出一个InterruptedException。 ReentrantLock.lock方法不允许Thread.interrupt中断,即使检测到Thread.isInterrupted,一样会继续尝试获取锁，失败则继续休眠。只是在最后获取锁成功后再把当前线程置为interrupted状态,然后再中断线程。）
7.synchronized采用的是monitor对象监视器，lock的底层原理是AQS
8.synchronized只有一个同步队列和一个等待队列，而lock有一个同步队列，可以有多个等待队列。
同步队列：排队取锁的线程所在的队列。
等待队列：调用 wait 方法后，线程会从同步队列转移到等待队列。
9.synchronized是非公平锁，而lock可以是公平锁也可以是非公平锁。
10.synchronized用object的notify方法进行唤醒，而lock用condition进行唤醒。
11.lock有ReadWriteLock支持并发读。
```