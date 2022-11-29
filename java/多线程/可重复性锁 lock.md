# Lock 锁
``` java
public class ThreadLock implements Runnable {
    int num = 10;
    private final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        ThreadLock lock2 = new ThreadLock();
        new Thread(lock2).start();
        new Thread(lock2).start();
        new Thread(lock2).start();
    }
    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (num > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(num--);
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
```