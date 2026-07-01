package day20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入文件路径：");
        String path = sc.nextLine();
        while (true) {
            System.out.print("请输入要添加的内容（输入end退出）：");
            String s = sc.nextLine();
            if("end".equals(s)) {
                System.out.println("正在退出！");
                break;
            }

            try (FileOutputStream out = new FileOutputStream(path,true)){
                ;
                byte[] bytes = s.getBytes();
                out.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}