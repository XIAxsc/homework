package main.java.day20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        String s = sc.nextLine();
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            byte[] bytes = s.getBytes();
            out.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out != null){
                    out.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
