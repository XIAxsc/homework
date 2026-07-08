package test.string;

import java.util.Scanner;

/*
请键盘录入一个任意字符串s，并用一个temp字符串引用也指向它
这个时候修改temp字符串的内容，请问s字符串的内容会随之改变吗？
 */
public class no1 {
    public static void main(String[] args) {
        // 创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        // 键盘接收nextLine   -- > s
        String s = scanner.nextLine();
        // temp 指向
        String temp = s;
        // 更改s内容
        s = "aaa";
        // 打印
        System.out.println("temp = " + temp);
        System.out.println("s = " + s);

        String s2 = "张三";
        System.out.println("s = " + s2);
        s2 = "hello 张三";
        System.out.println("s = " + s2);

    }
}