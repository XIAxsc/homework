package test.hashcode;

import java.util.Objects;

public class demo1 {
    public static void main(String[] args) {
        Student stu1 = new Student(1001,"张三",18);
        Student stu2 = new Student(1001,"张三",18);
        Student stu3 = new Student(1003,"张三疯",180);

        System.out.println(stu1.equals(stu2));
        System.out.println(stu1.equals(stu3));
        System.out.println("stu1.hashCode() = " + stu1.hashCode());
        System.out.println("stu2.hashCode() = " + stu2.hashCode());
        System.out.println("stu3.hashCode() = " + stu3.hashCode());
        System.out.println("stu1 = " + stu1);
    }
}
class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}