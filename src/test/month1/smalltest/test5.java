package test.smalltest;

import java.util.Scanner;


public class test5 {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void printHelloWorld() {
        System.out.println("hello world！");
    }

    public static int maxOfTwo(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static double calculator(double a, char b, double c) {
        if (b == '+') {
            return a + c;
        } else if (b == '-') {
            return a - c;
        } else if (b == '*') {
            return a * c;
        } else if (b == '/') {
            return a / c;
        } else return 0;
    }


    public static void main(String[] args) {
        int x = 100;
        int y = 99;
        int max1 = maxOfTwo(x, y);
        System.out.println("求两个数的最大值：" + max1);

        Scanner sc = new Scanner(System.in);
        System.out.print("键盘录入两个数：");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int max2 = maxOfTwo(m, n);
        System.out.println("键盘录入两个数的最大值是：" + max2);

        printHelloWorld();
    }
}

