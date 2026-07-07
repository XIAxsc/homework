package month1.day24;

public class Demo4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task4(1), "t1");
        Thread t2 = new Thread(new Task4(2), "t2");
        Thread t3 = new Thread(new Task4(3), "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Task4 implements Runnable {
    static int i = 0;
    int sign;

    public Task4(int sign) {
        this.sign = sign;
    }

    // 用.class对象做锁对象，即使创建不同thread的Task4对象不同，这几个thread也是进同一个锁
    // public static final Object OBJECT = new Object();

    // 0,5,10,15
    // 0,1,2,3
    // 0,1,2,0

    /**
     * if(i/5%3+1 == sign)
     */

    @Override
    public void run() {
        while (i < 75) {
            synchronized (Task4.class) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Task4.class.notifyAll();
                if (i / 5 % 3 + 1 == sign) {
                    i += 1;
                    System.out.println(Thread.currentThread().getName() + "线程：" + i);
                } else {
                    try {
                        Task4.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
//     @Override
//     public void run() {
//         int count = 5;
//         while (i < 76) {
//             synchronized (OBJECT) {
//                 OBJECT.notifyAll();
//                 if (Thread.currentThread().getName().equals("t1")) {
//                     if (sign == 1) {
//                         if (count > 0) {
//                             System.out.println("线程t1打印：" + i);
//                             i += 1;
//                             count -= 1;
//                         } else {
//                             count = 5;
//                             sign = 2;
//                             try {
//                                 OBJECT.wait();
//                             } catch (InterruptedException e) {
//                                 e.printStackTrace();
//                             }
//                         }
//                     } else {
//                         try {
//                             // OBJECT.notifyAll();
//                             OBJECT.wait();
//                         } catch (InterruptedException e) {
//                             e.printStackTrace();
//                         }
//                     }
//                 }
//                 else if (Thread.currentThread().getName().equals("t2")) {
//                     if (sign == 2) {
//                         if (count > 0) {
//                             System.out.println("线程t2打印：" + i);
//                             i += 1;
//                             count -= 1;
//                         } else {
//                             count = 5;
//                             sign = 3;
//                             try {
//                                 OBJECT.wait();
//                             } catch (InterruptedException e) {
//                                 e.printStackTrace();
//                             }
//                         }
//                     } else {
//                         try {
//                             // OBJECT.notifyAll();
//                             OBJECT.wait();
//                         } catch (InterruptedException e) {
//                             e.printStackTrace();
//                         }
//                     }
//                 }
//                 else if (Thread.currentThread().getName().equals("t3")) {
//                     if (sign == 3) {
//                         if (count > 0) {
//                             System.out.println("线程t3打印：" + i);
//                             i += 1;
//                             count -= 1;
//                         } else {
//                             count = 5;
//                             sign = 1;
//                             try {
//                                 OBJECT.wait();
//                             } catch (InterruptedException e) {
//                                 e.printStackTrace();
//                             }
//                         }
//
//                     } else {
//                         try {
//                             // OBJECT.notifyAll();
//                             OBJECT.wait();
//                         } catch (InterruptedException e) {
//                             e.printStackTrace();
//                         }
//                     }
//                 }
//             }
//         }
//     }
}
