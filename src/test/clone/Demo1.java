package test.clone;

import java.util.Objects;

/**
 * 用到clone的地方需要throws CloneNotSupportedException，调用clone的类需要implements Cloneable；
 * 浅度克隆：
 *      指clone时只把所有的值克隆了，如果类中有引用数据类型的成员变量，只把引用数据类型的地址克隆的话，
 *      克隆后的引用数据类型指向的对象还是克隆前的引用数据类型指向的对象
 * 深度克隆：
 *      比浅度克隆更进一步的克隆，把类的引用数据类型成员变量指向的对象也克隆一遍，
 *      然后再用克隆后的引用指向这个克隆后的对象
 *
 * 注意：
 *      克隆前最好重写一下equals和hashcode
 *
 */


public class Demo1 {
    public static void main(String[] args) throws CloneNotSupportedException {

        Teacher t1 = new Teacher("李四");
        Teacher t2 = new Teacher("李四");
        Teacher t3 = new Teacher("李思思");

        Student stu1 = new Student(1001, "张三", 18, t1);
        Student stu2 = new Student(1001, "张三", 18, t1);
        Student stu3 = new Student(1003, "张三疯", 180, t3);



        Student stu4 = stu1.clone();

        System.out.println("stu1 == stu2 is " + stu1.equals(stu2));
        System.out.println(stu1.equals(stu3));
        System.out.println(stu2.equals(stu3));
        System.out.println(stu1.equals(stu4));
        System.out.println("stu1.teacher.equals(stu4.teacher) = " + stu1.teacher.equals(stu4.teacher));

        System.out.println();

        System.out.println("stu1 = " + stu1);
        System.out.println("stu2 = " + stu2);
        System.out.println("stu3 = " + stu3);
        System.out.println("stu4 = " + stu4);
    }
}

class Student implements Cloneable{
    int id;
    String name;
    int age;

    Teacher teacher;

    public Student(int id, String name, int age, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id && age == student.age && Objects.equals(name, student.name) && Objects.equals(teacher, student.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, teacher);
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student cloneStu = (Student) super.clone();
        cloneStu.teacher = (Teacher) cloneStu.teacher.clone();
        return cloneStu;
    }
}
class Teacher implements Cloneable{
    String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher teacher)) return false;
        return Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}