package main.java.day4;

import java.util.Scanner;

public class No3 {

    public static int getMax(int[] arr) {

        int max = arr[0];
        for (int i : arr) {
            max = i > max ? i : max;
        }
        return max;

    }

    public static int getMin(int[] arr) {

        int min = arr[0];
        for (int i : arr) {
            min = i < min ? i : min;
        }
        return min;

    }

    public static double average(int[] arr, int max, int min) {

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return (double) (sum - max - min) / (arr.length - 2);
    }

    public static void main(String[] args) {
        int[] judges = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入十个评委的评分：");
        for (int i = 0; i < 10; i++) {
            judges[i] = sc.nextInt();
        }
        int max = getMax(judges);
        int min = getMin(judges);
        double avg = average(judges, max, min);
        System.out.println("最终成绩是：" + avg);
    }

}
