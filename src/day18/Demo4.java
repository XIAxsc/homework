package day18;

import java.security.SecureRandom;

public class Demo4 {
    public static void main(String[] args) {
        SecureRandom SECURE_RANDOM = new SecureRandom();

        int number = SECURE_RANDOM.nextInt(1000);
        String s = String.format("%03d", number);
        for (int i = 0; i < 1000; i++) {
            String hack = String.format("%03d", i);
            if (!hack.equals(s)){
                System.out.println("可能的密码：" + hack);
            }
            else {
                System.out.println("匹配上的密码：" + hack);
                break;
            }
        }
        System.out.println("真的密码：" + s);
    }
}
