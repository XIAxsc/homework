package month1.day12;

public class Demo7 {
    public static void main(String[] args) {
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类任务");
            }
        };

        // Runnable task1 = () -> System.out.println("匿名内部类任务");
    }
}
