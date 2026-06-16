package test;

public class Demo {
    public static void main(String[] args) {
        Student stu = new Student(18, "王冰冰");
    }
}

class Student {
    int age = 10;
    String name = "张三";
    double a = 100;

    public Student(int age) {
        System.out.println("Student age" + age);
        this.age = age;
    }

    public Student() {
    }

    public Student(int age, String name) {
        this(age);
        System.out.println("Student age，name");
        this.name = name;
    }
}
