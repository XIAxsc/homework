package test.network.TCP;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        // 建立连接
        Socket socket = new Socket("127.0.0.1", 1000);

        // 创建缓冲输入字节流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("start/Client.java"));

        // 创建输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        // 读入文件并传输
        byte[] bytes = new byte[4096];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        // 写出结束标记
        socket.shutdownOutput();

        // 获取服务器回馈,读入，字节流转字符流，在转缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        line = br.readLine();
        System.out.println(line);

        // 释放资源
        socket.close();
    }
}
