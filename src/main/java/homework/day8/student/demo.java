package homework.day8.student;

class Student {
    private String name;
    private String gender;
    private int id;
    static int count = 0;

    private Student(String name, String gender, int id) {
        this.name = name;
        this.gender = gender;
        this.id = id;
    }

    private Student() {

    }

    public static Student createStudent(String name, String gender, int id){
        if(count >= 10){
            System.out.println("已经有了10个Student对象，无法创建新的Student对象");
            return null;
        }
        count++;
        return new Student(name,gender,id);
    }

    public static Student createStudent(){
        if(count >= 10){
            System.out.println("已经有了10个Student对象，无法创建新的Student对象");
            return null;
        }
        count++;
        return new Student();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id + ", count=" + count +
                '}';
    }
}
 public class demo{
    public static void main(String[] args) {
        // private修饰构造器，无法直接创建对象
        // Student s1 = new Student();

        // 调用工具方法createStudent创建无参数对象
        Student s2 = Student.createStudent();
        System.out.println(s2);

        // 创建有参数对象
        Student s3 = Student.createStudent("张三", "男" , 10010);
        System.out.println(s3);

        Student s4 = Student.createStudent();
        Student s5 = Student.createStudent();
        Student s6 = Student.createStudent();
        Student s7 = Student.createStudent();
        Student s8 = Student.createStudent();
        Student s9 = Student.createStudent();
        Student s10 = Student.createStudent();
        Student s11 = Student.createStudent();
        System.out.println(s11);
        Student s12 = Student.createStudent();
        System.out.println(s12);
        Student s13 = Student.createStudent();
        System.out.println(s13);
    }
}
