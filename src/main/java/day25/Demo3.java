package main.java.day25;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Demo3 {
}

class Student {
    String name;
    int age;
    int score;

    public Student() {
    }


    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public void eat() {
        System.out.println("学生" + name + "在吃饭！");
    }
}

class TestStudent {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生信息：");
        String input = sc.nextLine();
        String[] studentInfo = input.split(":");
        Student student = new Student();
        Class clazz = student.getClass();
        Constructor allParamConstructor = clazz.getDeclaredConstructor(String.class, int.class, int.class);
        student = (Student) allParamConstructor.newInstance(studentInfo[0], Integer.parseInt(studentInfo[1]), Integer.parseInt(studentInfo[2]));
        System.out.println("student = " + student);
    }
}