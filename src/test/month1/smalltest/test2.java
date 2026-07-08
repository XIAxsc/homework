package test.smalltest;

class Teacher {
    // 默认赋值 0，null
    public int age = 0;
    public String course = "";
    // 显式赋值 0，“”

    public Teacher() {
        this(0, null);
        System.out.println("无参的构造方法执行了");
    }

    public Teacher(String course) {
        this(0, course);
    }


    public Teacher(int age, String course) {
        System.out.println("双参数的构造方法执行了");
        // 构造器赋值

        this.age = age;
        this.course = course;
    }

    public void teach() {
        System.out.println(age + "岁的老师教" + course);
    }
}

public class test2 {
    public static void main(String[] args) {
        Teacher t1 = new Teacher(18, "Python");
        Teacher t2 = new Teacher(22, "Java");
        Teacher t3 = new Teacher(28, "C/C++");

        t1.teach();
        t2.teach();
        t3.teach();

    }
}
