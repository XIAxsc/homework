package main.java.day5;

import java.util.Scanner;

public class _5_n_lines {
    // n条直线要把一个平面尽可能分成更多块，每两条直线都要两两相交且所有交点不能重合
    // 2  4  7  11  16
    // 1  2  3  4   5
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入直线数量n：");
        int n = sc.nextInt();

        int blocks = getBlocks(n);

        System.out.println(n + "条直线最多能把平面分成" + blocks + "份。");

    }

    public static int getBlocks(int n) {
        if (n == 1) {
            return 2;
        }
        return getBlocks(n - 1) + n;
    }
}
