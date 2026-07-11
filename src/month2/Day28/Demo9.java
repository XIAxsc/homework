package month2.Day28;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Demo9 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        while (true) {
            System.out.println("1.输入delete进入删除功能\n2.输入display显示学生名单\n3.输入quit退出程序\n请输入学生姓名：");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if ("quit".equals(s)) break;
            else if ("delete".equals(s)) {
                System.out.println("请输入要删除的学生的姓名：");
                String deleteString = sc.nextLine();
                Iterator<Student> iterator = students.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().name.equals(deleteString)) {
                        iterator.remove();
                        System.out.println("删除成功！");
                    }
                }
            } else if ("display".equals(s)) {
                System.out.println("学生名单如下：" + students);
            } else students.add(new Student(s));
        }

    }
}

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
