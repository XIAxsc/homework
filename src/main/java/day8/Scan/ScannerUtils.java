package day8.Scan;

import java.util.Scanner;

public class ScannerUtils {

    private static Scanner sc = new Scanner(System.in);
    private ScannerUtils(){
    }

    public static String scanString(){
        System.out.println("请键盘输入一串字符串：");
        return sc.nextLine();
    }

    public static int scanInt(){
        System.out.println("请键盘输入int类型整数：");
        return Integer.parseInt(sc.nextLine());
    }

    // 调用了同包下的Person类（包含name成员变量和单参构造方法以及无参构造方法）
    public static Person scanPerson(){
        System.out.println("请键盘输入一个Person对象：");
        String name = sc.nextLine();
        return new Person(name);
    }

    public static void main(String[] args) {
        System.out.println("scanString() = " + scanString());

        System.out.println("scanInt() = " + scanInt());

        System.out.println("scanPerson() = " + scanPerson().name);
    }
}
