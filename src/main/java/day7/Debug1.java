package main.java.day7;

public class Debug1 {
    public static void main(String[] args) {
        System.out.println(Person.nationality);
        Person p = new Person(18);
    }
}
class Person {
    int age = 10;
    static String nationality = "美国";

    public Person(int age) {
        this.age = age;
        System.out.println(nationality);
    }


    public Person() {
    }

    public Person(String nationality) {
        Person.nationality = nationality;
    }
}

class Students {
    int age = 10;
    String name = "张三";
    double a = 100;

    public Students(int age) {
        System.out.println("Student age");
        this.age = age;
    }

    public Students() {
    }

    public Students(int age, String name) {
        this(age);
        System.out.println("Student age,name");
        this.name = name;
    }
}
