package test.deadlock;

import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {
    public static void main(String[] args) {

        ThreadLock threadLock = new ThreadLock();

        Thread t1 = new Thread(threadLock, "t1");
        Thread t2 = new Thread(threadLock, "t2");

        t1.start();
        t2.start();
    }
}

class ThreadLock implements Runnable {
    int pool = 100;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        System.out.println("thread t1 started!");

        while (true) {
            lock.lock();
            try {
                if (pool > 0) {
                    pool -= 1;

                    System.out.println(Thread.currentThread().getName() + " pool:" + pool);
                } else break;
            } finally {
                lock.unlock();
            }
        }
    }
}