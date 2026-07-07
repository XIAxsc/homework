package month1.day24;

import java.util.concurrent.*;

public class Demo3 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        Thread t1 = new Thread(new Task(), "t1");
        Thread t2 = new Thread(new Task(), "t2");
        Thread t3 = new Thread(new Task(), "t3");
        Thread t4 = new Thread(new Task(), "t4");
        Thread t5 = new Thread(new Task(), "t5");
        Thread t6 = new Thread(new Task(), "t6");
        Thread t7 = new Thread(new Task(), "t7");
        Thread t8 = new Thread(new Task(), "t8");
        Thread t9 = new Thread(new Task(), "t9");
        Thread t10 = new Thread(new Task(), "t10");

        pool.submit(t1);
        pool.submit(t2);
        pool.submit(t3);
        pool.submit(t4);
        pool.submit(t5);
        pool.submit(t6);
        pool.submit(t7);
        pool.submit(t8);
        pool.submit(t9);
        pool.submit(t10);

        pool.shutdown();
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        long sleepTime = ThreadLocalRandom.current().nextLong(0, 10);
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName() + "的睡眠时间：" + sleepTime + "秒");
    }
}