package day1;

import java.util.Scanner;

public class Income {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入工资收入：");
        double salary = sc.nextDouble();
        double tax = 0;
        double finalSalary;
        if(salary - 2000 > 0 && salary - 2000 <= 500){
            tax = (salary - 2000)*0.05;
        } else if (salary - 2000 > 500 && salary - 2000 <= 2000) {
            tax = (salary - 2000)*0.1 - 25;
        } else if (salary - 2000 > 2000 && salary - 2000 <= 5000) {
            tax = (salary - 2000)*0.15 - 125;
        } else if (salary - 2000 > 5000 && salary - 2000 <= 20000) {
            tax = (salary - 2000)*0.2 - 375;
        } else if (salary - 2000 > 20000 && salary - 2000 <= 40000) {
            tax = (salary - 2000)*0.25 - 1375;
        } else if (salary - 2000 > 40000 && salary - 2000 <= 60000) {
            tax = (salary - 2000)*0.3 - 3375;
        } else if (salary - 2000 > 60000 && salary - 2000 <= 80000) {
            tax = (salary - 2000)*0.35 - 6375;
        } else if (salary - 2000 > 80000 && salary - 2000 <= 100000) {
            tax = (salary - 2000)*0.4 - 10375;
        } else if (salary - 2000 > 100000 ) {
            tax = (salary - 2000)*0.45 - 15375;
        }
        finalSalary = salary - tax;
        System.out.println("缴纳的个税是：" + tax);
        System.out.println("到手工资：" + finalSalary);
    }
}
