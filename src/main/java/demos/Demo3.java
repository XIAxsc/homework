package demos;

/**
 * 多线程场景下的数据安全问题
 * <p>
 * 2. 使用同步方法
 * public synchronized void method(){
 * <p>
 * }
 * <p>
 * 同步方法的本质还是同步代码块，一样的使用synchronized来加锁
 * 那么问题是：同步方法的锁对象是什么呢？
 * <p>
 * this(调用该方法的当前对象)
 */
public class Demo3 {

    public static void main(String[] args) {

        // 创建Runnable接口的子类对象
        SellTask3 sellTask3 = new SellTask3();

        // 创建线程
        Thread t1 = new Thread(sellTask3, "窗口A");
        Thread t2 = new Thread(sellTask3, "窗口B");
        Thread t3 = new Thread(sellTask3, "窗口C");


        // 启动线程
        t1.start();
        t2.start();
        t3.start();

    }
}

class SellTask3 implements Runnable {

    // 定义票数
    int tickets = 100;

    // 定义一把锁
    public static final Object OBJECT = new Object();


    @Override
    public void run() {

        while (true) {

            // 为了方便演示出效果，所以加上线程睡眠（其实不加也可以）
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            if (tickets % 2 == 0) {

                // try {
                //     Thread.sleep(100);
                // } catch (InterruptedException e) {
                //     throw new RuntimeException(e);
                // }

                synchronized (this) {
                    if (tickets > 0) {

                        // tickets --;
                        // tickets = tickets -1;

                        // 卖票
                        int ticket = tickets;       // 获取值
                        ticket = ticket - 1;        // 修改值
                        tickets = ticket;           // 更新值

                        // 打印
                        System.out.println(Thread.currentThread().getName() + "同步代码块卖票进行中，还剩余:" + tickets + " 张票" + "锁对象：" + this.getClass().getName());
                    }
                }
            } else {
                sellTickets();
            }

        }

    }

    private synchronized void sellTickets() {
        if (tickets > 0) {

            // try {
            //     Thread.sleep(100);
            // } catch (InterruptedException e) {
            //     throw new RuntimeException(e);
            // }

            // tickets --;
            // tickets = tickets -1;

            // 卖票
            int ticket = tickets;       // 获取值
            ticket = ticket - 1;        // 修改值
            tickets = ticket;           // 更新值

            // 打印
            System.out.println(Thread.currentThread().getName() + "同步方法卖票进行中，还剩余:" + tickets + " 张票" + "锁对象：" + this.getClass().getName());
        }
    }


}
