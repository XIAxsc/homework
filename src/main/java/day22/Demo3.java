package day22;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Demo3 {
    public static void main(String[] args) {
        int number = ThreadLocalRandom.current().nextInt(1000);
        // 格式化为 3 位，不足补零
        String password = String.format("%03d", number);
        System.out.println("随机生成的密码是:" + password);

        new Thread(() -> {
            String[] tryDecode = new String[1000];
            System.out.println("破解进程开始执行了！");
            for (int i = 0, j = 0; i < 1000; i++) {
                String decode = String.format("%03d", i);
                if (decode.equals(password)) {
                    System.out.println("已破解密码，该密码是：" + decode);
                    Thread t = new ThreadDaemon(decode, tryDecode);
                    t.setDaemon(true);
                    t.start();

                    // 破解线程执行完了，日志线程在他结束前插队
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 破解线程执行完了等待3秒来执行日志线程
                    // try {
                    //     Thread.sleep(3000);
                    // } catch (InterruptedException e) {
                    //     e.printStackTrace();
                    // }
                    break;
                } else {
                    tryDecode[j] = decode;
                    j += 1;
                }
            }

        }).start();


    }
}

class ThreadDaemon extends Thread {
    String decode;
    String[] decodes;

    public ThreadDaemon(String decode, String[] decodes) {
        this.decode = decode;
        this.decodes = decodes;
    }

    @Override
    public void run() {
        try {
            System.out.println("日志进程开始执行了！");
            BufferedWriter writer = new BufferedWriter(new FileWriter("testjava/log.txt"));

            for (String s : decodes) {
                if (s != null) {
                    writer.write(s);
                    writer.newLine();
                }
            }
            writer.write("破解出来的密码：" + decode);

            writer.close();
            System.out.println("日志进程执行成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
