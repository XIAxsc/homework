package test.month1.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Integer b = sc.nextInt();
            // if(b==0){
            //     throw new ArithmeticException("除数不能为0");
            // }
            Integer a = 10010;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (InputMismatchException e) {
            System.out.println("请输入合法的整数");
        } finally {
            System.out.println("程序结束！！！！");
            // return;
        }
    }
}
