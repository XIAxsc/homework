package day18;

import java.util.Scanner;

public class Demo6 {

    static void judge(String s) {
        char[] c = s.toCharArray();
        for (int i = 0,j = c.length - 1; i < j; i++ , j--) {
            if(c[i] != c[j]){
                System.out.println("该字符串不是对称字符串");
                return;
            }
        }
        System.out.println("该字符串是对称字符串");
    }
    public static void main(String[] args) {
        //示例 mnanm abc
        System.out.println("示例mnanm：");
        judge("mnanm");
        System.out.println("示例abc：");
        judge("abc");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String s = sc.nextLine();

        judge(s);
    }
}
