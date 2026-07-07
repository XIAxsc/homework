package month1.day24;

public class Demo1 {
    public static final Object obj = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            String s = "1A2B3C4D5E6F7G";
            synchronized (obj) {
                for (int i = 0; i < s.length(); i += 2) {
                    obj.notify();
                    System.out.println("线程" + Thread.currentThread().getName() + "打印" + s.toCharArray()[i]);
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            String s = "1A2B3C4D5E6F7G";
            synchronized (obj) {
                for (int i = 1; i < s.length(); i += 2) {
                    obj.notify();
                    System.out.println("线程" + Thread.currentThread().getName() + "打印" + s.toCharArray()[i]);
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}

