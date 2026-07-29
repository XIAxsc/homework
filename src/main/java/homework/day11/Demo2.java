package homework.day11;

public class Demo2 {
    public static void main(String[] args) {
        Person p1 = new Teacher("张三", "男", 9999);
        Person p2 = new Student("李四", "男", 1);

        System.out.println(p1);
        System.out.println(p2);

        p1.eat();
        p1.sleep();
        // p1.ability();
        p2.eat();
        p2.sleep();
        // p2.ability();
    }
}

abstract class Person {
    String name = "MAN";
    String gender = "直升机";
    int age = 6;

    public Person() {
    }

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    abstract void eat();

    abstract void sleep();
}

interface SkillLearning {
    void ability();
}

class Teacher extends Person implements SkillLearning {
    public Teacher() {
    }

    public Teacher(String name, String gender, int age) {
        super(name, gender, age);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    void eat() {
        System.out.println(age + "岁的" + gender + "老师" + name + "在吃饭");
    }

    @Override
    void sleep() {
        System.out.println(age + "岁的" + gender + "老师" + name + "在睡觉");
    }

    @Override
    public void ability() {
        System.out.println(name + "老师需要增强语言能力");
    }
}

class Student extends Person implements SkillLearning {
    public Student() {
    }

    public Student(String name, String gender, int age) {
        super(name, gender, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    void eat() {
        System.out.println(age + "岁的" + gender + "学生" + name + "在吃饭");
    }

    @Override
    void sleep() {
        System.out.println(age + "岁的" + gender + "学生" + name + "在睡觉");
    }

    @Override
    public void ability() {
        System.out.println(name + "学生需要增强实践动手能力");
    }
}