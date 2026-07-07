package test.threadpool;

public class Demo1 {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("cores = " + cores);
    }
}
