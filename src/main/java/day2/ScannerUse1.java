package main.java.day2;

import java.util.Scanner;

public class ScannerUse1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数学成绩：");
        double math = sc.nextDouble();
        System.out.print("请输入语文成绩：");
        double chinese = sc.nextDouble();
        System.out.print("请输入英语成绩：");
        double english = sc.nextDouble();
        double avg;
        double min;
        double max;
        double sum;
        sum = math + chinese + english;
        avg = sum / 3;
        max = math;
        if(english > max)max = english;
        if(chinese > max)max = chinese;
        min = math;
        if(english < min)min = english;
        if(chinese < min)min = chinese;

        System.out.println("三科成绩的平均分是：" + avg);
        System.out.println("三科成绩的最低分是：" + min);
        System.out.println("三科成绩的最高分是：" + max);
        System.out.println("三科成绩的总分是：" + sum);

    }
}
