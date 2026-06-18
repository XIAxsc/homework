package day10.a;

public class Student {
    int a;
    protected void hello(){
        System.out.println("hello Student a");
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.hello();
        // s1.clone();
    }
}
