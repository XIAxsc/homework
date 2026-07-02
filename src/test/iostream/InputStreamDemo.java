package test.iostream;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/*
循环读取数据
 */
public class InputStreamDemo {
    public static void main(String[] args) throws IOException {

        // 字符流输出
        FileWriter writer = new FileWriter("test/a.py");
        writer.write("a = 10\nb = 20\nprint(a + b)\n");
        writer.close();

        // 字符缓存输出
        BufferedWriter bw = new BufferedWriter(new FileWriter("test/a.py",true));
        bw.newLine();
        bw.write("print('hello')");
        bw.close();

        // 创建字节输入流对象
        FileInputStream in = new FileInputStream("test/a.py");

        // 循环
        // readWhile1(in);

        // 新的方式
        // 单字节读取
        // readWhile2(in);

        // 字节数组方式
        int readCount;
        byte[] bytes = new byte[1024];
        while ((readCount = in.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,readCount));
        }


        // close
        in.close();
    }

    private static void readWhile2(FileInputStream in) throws IOException {
        int readData;
        // == -1 就结束循环 意味文件里读取完了
        while ((readData = in.read()) != -1) {
            System.out.println(((char) readData));

        }
    }

    private static void readWhile1(FileInputStream in) throws IOException {
        while (true) {
            // read
            int readData = in.read();
            if (readData == -1) {
                break;
            }
            System.out.println(((char) readData));

        }
    }
}
