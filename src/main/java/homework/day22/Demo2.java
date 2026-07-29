package homework.day22;

public class Demo2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("线程T1执行了"));
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("线程T2执行了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("线程T3执行了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
