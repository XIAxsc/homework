package homework.day6;

import java.util.Scanner;

public class StudentManagerSystem {

    public static void printStudents(String[] students) {
        System.out.print("学生列表如下：");
        for(String element:students){
            if(element != null){
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

    public static String[] addStudent(String newStu, String[] students) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("学生列表已满，已创建新学生列表并继续增加学生。");
            String[] arr = new String[students.length + 1];
            System.arraycopy(students, 0, arr, 0, students.length);
            arr[students.length] = newStu;
            return arr;
        }
        students[index] = newStu;
        return students;
    }

    public static String[] deleteStudent(String newStu, String[] students) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (newStu.equals(students[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("没找到要删除的学生");
            return students;
        }
        students[index] = null;
        return students;
    }

    public static void updateStudent(String stu, String newStu, String[] students) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (stu.equals(students[i])) {
                index = i;
                students[index] = newStu;
                break;
            }
        }
        if (index == -1) {
            System.out.println("没找到要修改的学生信息");
        }

    }

    public static void searchStudent(String stu, String[] students) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (stu.equals(students[i])) {
                index = i;
                System.out.println("该学生信息在数组中的的下标是：" + index);
            }
        }
        if (index == -1) {
            System.out.println("没找到要查询的学生信息");
        }
    }

    public static void printMenu(){
        System.out.println("\n-----------------王道Java学生管理系统-----------------\n");
        System.out.println("                   1.学 生 列 表");
        System.out.println("                   2.增 加 学 生");
        System.out.println("                   3.删 除 学 生");
        System.out.println("                   4.修 改 学 生");
        System.out.println("                   5.查 询 学 生");
        System.out.println("                   6.退 出 系 统\n");
        System.out.print("请选择功能(1-6)：");
    }

    public static void startSystem(String[] students){
        System.out.println("是否要启动本系统？请在下方输入true或者false：");
        Scanner sc = new Scanner(System.in);
        boolean loopFlag = Boolean.parseBoolean(sc.nextLine());
        while (loopFlag) {
            printMenu();
            int input = Integer.parseInt(sc.nextLine());
            // 对输入的单个数值做判断,很适合使用switch
            switch (input) {
                case 1:
                    printStudents(students);
                    break;
                case 2:
                    System.out.println("请输入要增加的学生信息");
                    String stu1 = sc.nextLine();
                    students = addStudent(stu1,students);
                    break;
                case 3:
                    System.out.println("请输入要删除的学生信息");
                    String stu2 = sc.nextLine();
                    deleteStudent(stu2,students);
                    break;
                case 4:
                    System.out.println("请输入要修改的学生信息");
                    String stu3 = sc.nextLine();
                    System.out.println("请输入修改后的学生信息");
                    String stu4 = sc.nextLine();
                    updateStudent(stu3,stu4,students);
                    break;
                case 5:
                    System.out.println("请输入要查询的学生信息");
                    String stu5 = sc.nextLine();
                    searchStudent(stu5,students);
                    break;
                case 6:
                    // 输入6退出后,询问用户是否确认退出
                    System.out.println("确认退出吗（1/2）：");
                    int quitFlag = sc.nextInt();
                    if (quitFlag == 1) {
                        // 用户确认退出,循环变量为false,死循环终止
                        loopFlag = false;
                        System.out.println("感谢使用本系统！");
                        /*
                            直接结束虚拟机
                            System.exit(0);
                         */
                    }
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        String[] students = {"刘备", "关羽", "张飞", "赵云", "诸葛亮", "黄忠", "马超",null};
        startSystem(students);
    }
}
