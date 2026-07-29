package main.java.day15;

/**
 * 分别定义以下类：
 * 教师类Teacher
 * 属性：int age;String name;Student stu
 * 学生类Student
 * 属性：int age；String name；Star s
 * 明星类Star
 * 属性：int age，String name
 * <p>
 * 尝试完成Teacher对象的深度克隆，并写代码进行测试
 * 注：String虽然也是引用数据类型，但无需考虑对它的对象进行深度克隆。
 */

public class Demo2 {
    public static void main(String[] args) throws Exception{
        Star star1 = new Star(30, "张伟");
        Student stu1 = new Student(15, "张三", star1);
        Teacher teacher1 = new Teacher(60, "李四", stu1);

        Teacher teacher2 = teacher1.clone();

        System.out.println("teacher2 = " + teacher2);
    }

}

class Teacher implements Cloneable {
    int age;
    String name;
    Student stu;

    public Teacher(int age, String name, Student stu) {
        this.age = age;
        this.name = name;
        this.stu = stu;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", stu=" + stu +
                '}';
    }

    @Override
    public Teacher clone() throws CloneNotSupportedException {
        Teacher teacherClone = (Teacher) super.clone();
        teacherClone.stu = teacherClone.stu.clone();
        return teacherClone;
    }
}

class Student implements Cloneable {
    int age;
    String name;
    Star s;

    public Student(int age, String name, Star s) {
        this.age = age;
        this.name = name;
        this.s = s;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", s=" + s +
                '}';
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student stuClone = (Student) super.clone();
        stuClone.s = stuClone.s.clone();
        return stuClone;
    }
}

class Star implements Cloneable {
    int age;
    String name;

    public Star(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Star{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public Star clone() throws CloneNotSupportedException {
        return (Star) super.clone();
    }
}