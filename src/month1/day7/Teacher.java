package month1.day7;

public class Teacher {
    String name;
    int age;
    String gender;
    int teacherId;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(String name, int teacherId) {
        this.name = name;
        this.teacherId = teacherId;
    }

    public Teacher(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Teacher(String name, int age, String gender, int teacherId) {
        this(name, age, gender);
        this.teacherId = teacherId;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void printInfo(){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("gender = " + gender);
        System.out.println("teacherId = " + teacherId);
    }

    public static void main(String[] args) {
        Teacher t1 = new Teacher("张三",18,"男",1);
        Teacher t2 =new Teacher("李四",25,"女", 2);

        t1.printInfo();
        t2.printInfo();
    }
}
