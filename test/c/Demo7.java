package month1.day18;

import java.util.Scanner;

public class Demo7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串数字");
        int i;
        while(true) {
            try {
                String s = sc.nextLine();
                i = Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                System.out.println("非法输入，请输入一串数字");
            }
        }
        System.out.println("输入的数字是：" + i);
    }
}
