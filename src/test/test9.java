package test;

/**
 * @author 夏盛成
 * @date 2026/06/22
 */
public class test9 {


    public static void main(String[] args) {
        ITest it = () -> System.out.println("这是匿名内部类");
        new ITest() {
            @Override
            public void test1() {
                System.out.println("！@#￥%……&");
            }
        };
        System.out.println(it);
        it.test1();


        Inter ity = () -> System.out.println("test1的测试");
        ity.show();


        Outer.method().show();
    }
}

interface ITest {
    void test1();
}

@FunctionalInterface
interface Inter {
    void show();
}

class Outer {
    public static Inter method() {
        return () -> System.out.println("hello world！");


        //  这是一个匿名内部类
        //  return new Inter(){
        //
        //    @Override
        //    public void show() {
        //        System.out.println("hello world!");
        //    }
        // };
    }
}