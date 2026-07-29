package homework.day4;

import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        while(true){
            System.out.println("-----------------王道Java学生管理系统-----------------");
            System.out.println();
            System.out.println("                   1.学 生 列 表");
            System.out.println("                   2.增 加 学 生");
            System.out.println("                   3.删 除 学 生");
            System.out.println("                   4.修 改 学 生");
            System.out.println("                   5.查 询 学 生");
            System.out.println("                   6.退 出 系 统");
            System.out.print("请选择功能（1-6）：");

            Scanner sc = new Scanner(System.in);
            int choose1 = sc.nextInt();

            // Switch更适合这种单一值做判断条件的多选择分支
            if(choose1 == 6){
                System.out.print("确认退出吗（1/2）：");
                int choose2 = sc.nextInt();
                if(choose2 == 1){
                    System.out.println("感谢使用本系统！");
                    break;
                }
            }
        }
    }

}
