package day21;

import java.io.*;
import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) throws Exception {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("testjava/b.txt"));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("testjava/b.txt", true));
        BufferedReader reader = new BufferedReader(new FileReader("testjava/b.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("testjava/b.txt", true));

        String s1 = "";
        byte[] bytes1 = new byte[10];
        int readCount = -1;
        while ((readCount = in.read(bytes1)) != -1) {
            s1 += new String(bytes1, 0, readCount);
        }
        byte[] bytes2 = s1.getBytes();
        Arrays.sort(bytes2);

        out.write("\r\n".getBytes());
        out.write("字节流：".getBytes());
        out.write("\r\n".getBytes());
        out.write(bytes2);

        in.close();
        out.close();

        String s2 = reader.readLine();
        byte[] bytes3 = s2.getBytes();
        Arrays.sort(bytes3);

        writer.newLine();
        writer.write("字符流：");
        writer.newLine();
        writer.write(new String(bytes3));

        reader.close();
        writer.close();

    }
}
