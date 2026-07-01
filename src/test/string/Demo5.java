package test.string;

import java.util.Arrays;
import java.util.Comparator;

public class Demo5 {
    public static void main(String[] args) {
        Student stu1 = new Student(1, "3");
        Student stu2 = new Student(2, "2");
        Student stu3 = new Student(3, "1");

        Student[] studs = new Student[]{stu1, stu2, stu3};
        int result = stu1.compareTo(stu2);

        System.out.println(result);

        System.out.println("排序前的studs = " + Arrays.toString(studs));
        // 匿名内部类：
        // Arrays.sort(studs, new Comparator<Student>() {
        //     @Override
        //     public int compare(Student o1, Student o2) {
        //         return o1.id - o2.id;
        //     }
        // });

        // lambda
        // Arrays.sort(studs, (o1 , o2) -> o2.id - o1.id);

        // 方法引用（类名引用成员方法）：
        Arrays.sort(studs, Student::compareTo);
        System.out.println("排序后的studs = " + Arrays.toString(studs));

    }
}

class Student implements Comparable<Student> {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return -(this.id - o.id);
    }
}
