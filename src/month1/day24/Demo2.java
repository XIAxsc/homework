package month1.day24;

import java.io.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        FutureTask futureTask1 = new FutureTask<>(new CloneFile());
        FutureTask futureTask2 = new FutureTask<>(new CloneFile());
        FutureTask futureTask3 = new FutureTask<>(new CloneFile());

        Thread t1 = new Thread(futureTask1, "t1");
        Thread t2 = new Thread(futureTask2, "t2");
        Thread t3 = new Thread(futureTask3, "t3");

        t1.start();
        t2.start();
        t3.start();

        String s1 = (String) futureTask1.get();
        String s2 = (String) futureTask2.get();
        String s3 = (String) futureTask3.get();

        BufferedWriter writer = new BufferedWriter(new FileWriter("test/day24/time.txt", true));
        writer.write(s1);
        writer.newLine();
        writer.write(s2);
        writer.newLine();
        writer.write(s3);
        writer.close();
    }
}

class CloneFile implements Callable {

    @Override
    public Object call() throws Exception {
        long start = System.currentTimeMillis();

        BufferedReader reader = new BufferedReader(new FileReader("test/day24/src.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("test/day24/" + Thread.currentThread().getName() + ".txt", true));

        String s;
        while ((s = reader.readLine()) != null) {
            writer.write(s);
            writer.newLine();
            writer.flush();
        }

        reader.close();
        writer.close();

        long end = System.currentTimeMillis();
        long result = end - start;
        return "线程" + Thread.currentThread().getName() + "执行时间是" + result + "ms";
    }
}
