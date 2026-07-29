package main.java.day5;

import java.util.Scanner;

public class _1_student_score {

    public static void main(String[] args) {
        double[] scores = new double[10];
        Scanner sc = new Scanner(System.in);
        System.out.print("第一题，请逐个输入10位同学的成绩：");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextDouble();
        }
        double avg = average(scores);
        System.out.println("这十位同学的平均成绩是：" + avg);

    }

    public static double average(double[] scores) {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }
}
