package month1.day23;

public class Demo1 {
    public static void main(String[] args) {
        download task = new download();

        Thread t1 = new Thread(task, "下载器1");
        Thread t2 = new Thread(task, "下载器2");
        Thread t3 = new Thread(task, "下载器3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class download implements Runnable {

    int source = 100;

    public static final Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                String threadName = Thread.currentThread().getName();
                if (source > 0) {
                    source--;
                    System.out.println("线程" + threadName + "已下载1M字节，还剩" + source + "M字节");
                } else break;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
