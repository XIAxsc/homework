package day4;

import java.util.Scanner;

public class No1 {

    public static void opOdds(int n) {
        int count = 0;
        System.out.print("n以内的奇数：");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
                count += i;
            }
        }
        System.out.println();
        System.out.println(n + "以内所有奇数的和等于" + count);
    }

    public static void invertedTriangle(int line) {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line - i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void multiplicationTable(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "x" + i + "=" + (j * i) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void judge(int num) {
        if (num % 2 == 0) {
            System.out.println("num = " + num + " 是偶数");
        } else {
            System.out.println("num = " + num + " 是奇数");
        }
    }

    public static void printSymbol(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print('#');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void primeNumber(int n) {
        // 求素数，首先素数只有1和它本身两个因数，且素数大于1
        // 其次，任何非素数的因数都小于它本身
        // 所以用取余是否为0判断是否为素数，遍历范围在0~这个数的一半
        int count = 0;
        System.out.print("前" + n + "个数当中的所有素数：");
        for (int i = 2; i <= n; i++) {
            // 2和3肯定是素数，直接打印
            if (i == 2 || i == 3) {
                System.out.print(i + " ");
                count += 1;
            } else {
                for (int j = 2; j <= i / 2; j++) {
                    // 判断这个i不是素数直接判定下一个i
                    if (i % j == 0) {
                        break;
                    } else if (j == i / 2) {           // 能完整执行完循环，说明是素数，打印i
                        System.out.print(i + " ");
                        count += 1;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("素数的个数为" + count + "个");
        ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 第一题：使用for循环遍历n以内(包括n)的奇数，并计算所有的奇数的和并输出。
        System.out.print("第一题，请输入一个正整数n：");
        int n1 = sc.nextInt();
        opOdds(n1);


        // 第二题：打印倒三角形，并且行数（line）是可控制的。
        System.out.print("第二题，请输入行数line：");
        int line = sc.nextInt();
        invertedTriangle(line);

        // 第三题：根据键盘录入打印nn乘法表，n是可变的。
        System.out.print("第三题，请输入一个正整数n：");
        int n2 = sc.nextInt();
        multiplicationTable(n2);

        // 第四题：键盘录入一个int数字，判断它是奇数还是偶数。
        System.out.print("第四题，请输入一个正整数num：");
        int num = sc.nextInt();
        judge(num);

        // 第五题：根据键盘录入打印n行m列井号，n和m是可变的。
        System.out.print("第五题，请输入行数n：");
        int n = sc.nextInt();
        System.out.print("第五题，请输入列数m：");
        int m = sc.nextInt();
        printSymbol(n, m);

        // 第六题：输出前n个数当中的所有素数，并统计个数。
        System.out.print("第六题，请输入一个正整数n：");
        int n3 = sc.nextInt();
        primeNumber(n3);
    }

}
