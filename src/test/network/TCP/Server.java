package test.network.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        // 创建对象
        ServerSocket ss = new ServerSocket(1000);

        // 接收连接
        Socket socket = ss.accept();

        // 读取数据,并保存到本地
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("target/client.java"));

        byte[] bytes = new byte[4096];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        // 写回数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("上传成功");
        bw.flush();

        // 释放资源
        socket.close();
        ss.close();
    }
}

