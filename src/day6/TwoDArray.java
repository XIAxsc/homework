package day6;

import java.util.Scanner;

public class TwoDArray {
    // public static void main(String[] args) {
    //     double[][] salesRevenue = {{30, 66, 48}, {10, 33, 20}, {10, 99, 103}, {9, 18, 27}};
    //     double[] sum = new double[4];
    //     double avg;
    //     double total = 0;
    //     for (int i = 0; i < salesRevenue.length; i++) {
    //         for (int j = 0; j < salesRevenue[i].length; j++) {
    //             sum[i] += salesRevenue[i][j];
    //             total += salesRevenue[i][j];
    //         }
    //     }
    //     for (int i = 0; i < 4; i++) {
    //         avg = sum[i] / 3;
    //         System.out.println("第" + (i + 1) + "季度平均销售额：" + avg);
    //     }
    //     System.out.println("年度销售总额：" + total);
    // }
    public static void main(String[] args) {
        double[][] scores = new double[3][];

        Scanner sc = new Scanner(System.in);

        scores[0] = new double[3];
        System.out.println("输入一班3个同学的成绩：");
        for (int i = 0; i < scores[0].length; i++) {
            scores[0][i] = sc.nextDouble();
        }


        scores[1] = new double[2];
        System.out.println("输入二班2个同学的成绩：");
        for (int i = 0; i < scores[1].length; i++) {
            scores[1][i] = sc.nextDouble();
        }

        scores[2] = new double[5];
        System.out.println("输入三班5个同学的成绩：");
        for (int i = 0; i < scores[2].length; i++) {
            scores[2][i] = sc.nextDouble();
        }

        Solve(scores);
    }

    public static void Solve(double[][] scores){
        for(int i = 0; i<scores.length;i++) {
            double sum = 0;
            double avg;
            double max = scores[i][0];
            double min = scores[i][0];
            for (double score : scores[i]) {
                if (score > max) {
                    max = score;
                }
                if (score < min) {
                    min = score;
                }
                sum += score;
            }
            avg = sum / scores[i].length;
            System.out.println((i+1)+"班平均成绩："+avg+"  最高成绩："+max+"  最低成绩："+min);
        }
    }
}
