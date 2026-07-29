package homework.day3;

import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        for (int i = 3; i > 0; i--) {

            Scanner sc = new Scanner(System.in);
            System.out.print("请输入用户名：");
            String username = sc.nextLine();
            System.out.print("请输入密码：");
            String password = sc.nextLine();
            if (username.equals("admin") && password.equals("123456")) {
                System.out.println("登陆成功！");
                return;
            } else{
                System.out.println("登录失败，还有" + (i-1) + "次机会。");
            }

        }
        System.out.println("3次登录失败，账户即将锁定，结束程序。");
    }
}
