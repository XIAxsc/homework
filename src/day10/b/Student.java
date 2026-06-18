package day10.b;

public class Student {
    int b;
    protected void hello(){
        System.out.println("hello Student b");
    }

    public static void main(String[] args) {
        day10.a.Student s1 = new day10.a.Student();
        // s1.hello();
    }
}
