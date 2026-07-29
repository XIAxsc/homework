package main.java.day2;

import java.util.Scanner;

public class ScannerUse2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入int类型数据：");
        String dataInt = sc.nextLine();
        System.out.print("请输入String类型数据：");
        String dataString = sc.nextLine();
        System.out.print("请输入double类型数据：");
        String dataDouble = sc.nextLine();

        int realInt = Integer.parseInt(dataInt);
        double realDouble = Double.parseDouble(dataDouble);

        // double sum = realInt + realDouble;

        System.out.println("int + double = " + (realInt + realDouble));
        System.out.println("int + double + String = " + dataInt + dataDouble + dataString);
    }
}
