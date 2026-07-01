package test;

import java.util.Arrays;
import java.util.Objects;

public class Demo {
    private static void update(Student[] studs,Student stu){
        for (int i = 0; i < studs.length; i++) {
            if(stu.age == studs[i].age){
                studs[i] = stu;
            }
        }
    }
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student(1,"张三"),
                new Student(2,"李四"),
                new Student(3,"王五"),
                new Student(4,"赵六")
        };
        Student newStu = new Student(3,"李白");

        update(students,newStu);

        System.out.println(Arrays.toString(students));
    }
}

class Student {
    int age = 10;
    String name = "张三";
    double a = 100;

    public Student(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(int age, String name) {
        this(age);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", a=" + a +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;

        if (age != student.age) return false;
        if (Double.compare(a, student.a) != 0) return false;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(a);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
