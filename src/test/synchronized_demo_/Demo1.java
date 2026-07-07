package test.synchronized_demo_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {
    public static void main(String[] args) {
        Apple apple = new Apple();

        Thread t1 = new Thread(apple, "哥哥");
        Thread t2 = new Thread(apple, "妹妹");

        t1.start();
        t2.start();
    }
}

class Apple implements Runnable {
    int apples = 100;

    public static final Object obj = new Object();

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "正在运行！");
        while (true) {
            synchronized (obj) {
                // lock.lock();
                if (apples > 0) {

                    apples--;
                    // int newApples = apples;
                    // newApples -= 1;
                    // apples = newApples;

                    System.out.println(threadName + "拿走了一个苹果，还剩" + apples + "个苹果");
                    // lock.unlock();
                } else {
                    // lock.unlock();
                    break;
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread.yield();
        }
    }
}
