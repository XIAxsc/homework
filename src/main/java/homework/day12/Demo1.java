package homework.day12;

public class Demo1 {
    public static void main(String[] args) {
        // 方法引用的左边必须是interface
        // B b = A::m1;

        // 匿名内部类的（）里不能放东西
        // int a=10;
        // new A(a){
        //     static int aa;
        //     static {
        //         int n;
        //     }
        //
        // };

        // 可以定义局部变量
        // IA iaa = () -> {
        //     int a;
        // };



    }
}
interface IA{
    void ia();
}
class A{
    int a;
    static void m1(){}
}
class B{
    void m2(){
    }
}
