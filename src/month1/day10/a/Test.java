package month1.day10.a;

public class Test {
    int a ;

    public static void t1(){
        Test t1 = new Test();
        t1.hello();
    }
    protected void hello(){
        System.out.println("hello Test");
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.hello();
        // s1.clone();
    }
}
