package month1.day14;

public class Demo1 {

    public static boolean isSameClass(Object a,Object b){
        return a.getClass()==b.getClass();
    }

    public static void main(String[] args) {
        A a1 = new A(1);
        A a2 = new A(1);
        B b = new B(1);

        Class a1Clazz = a1.getClass();
        Class a2Clazz = a2.getClass();
        Class bClazz = b.getClass();

        System.out.println(a1Clazz == a2Clazz);
        // 结果是true，因为a1和a2都是A的对象

        System.out.println(a1Clazz == bClazz);
        System.out.println(bClazz == a2Clazz);
        // false，false；a和b属于不同的类创建的对象

        System.out.println();

        System.out.println(isSameClass(a1,a2));
        System.out.println(isSameClass(a1,b));
        System.out.println(isSameClass(b,a2));
    }
}
class A{
    int a;

    public A(int a) {
        this.a = a;
    }
}
class B{
    int b;

    public B(int b) {
        this.b = b;
    }
}