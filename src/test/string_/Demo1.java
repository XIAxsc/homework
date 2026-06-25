package test.string_;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        // 利用字节数组，创建字节数组所表示的字符串
        // 1. 字符 -> 数值形式  'a' -> 97
        // 2. 所以可以用多个字节值，表示多个字符——>即字符序列 public
        // String(byte[] bytes)
        byte[] b = {99};
        String s = new String(b);
        System.out.println("s = " + s);

        // String对象不可变
        Scanner sc = new Scanner(System.in);
        System.out.print("输入字符串：");
        String string = sc.nextLine();
        String temp = string;
        String temp2 = new String(string);
        temp += " kksk ";
        temp2 += "hhhh";
        System.out.println("temp = " + temp);               // wwdl kksk
        System.out.println("temp2 = " + temp2);             // wwdlhhhh
        System.out.println("string = " + string);           // wwdl temp +=是重新指向了另一个对象
    }
}
