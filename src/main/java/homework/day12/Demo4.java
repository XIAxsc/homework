package homework.day12;

public class Demo4 {
    public static void main(String[] args) {
        INoReturnNoParam i1 = () -> System.out.println("INoReturnNoParam无返回值无参数的功能接口");
        i1.test();

        INoReturnOneParam i2 = a -> System.out.println("INoReturnOneParam无返回值一个参数的功能接口");
        i2.test(2);

        INoReturnTwoParam i3 = (a, b) -> System.out.println("INoReturnTwoParam无返回值两个参数的功能接口");
        i3.test(3,3);

        IHasReturnNoParam h1 = () -> {
            System.out.println("IHasReturnNoParam有返回值无参数的功能接口");
            return 0;
        };
        h1.test();

        IHasReturnOneParam h2 = a -> {
            System.out.println("IHasReturnOneParam有返回值一个参数的功能接口");
            return 0;
        };
        h2.method(2);

        IHasReturnTwoParam h3 = (a,b) -> {
            System.out.println("IHasReturnNoParam有返回值两个参数的功能接口");
            return 0;
        };
        h3.test(3,3);

    }
}
//无返回值无参数的功能接口
@FunctionalInterface
interface INoReturnNoParam {
    void test();
}

//无返回值有一个参数的功能接口
@FunctionalInterface
interface INoReturnOneParam {
    void test(int a);
}

//无返回值两个参数的功能接口
@FunctionalInterface
interface INoReturnTwoParam {
    void test(int a, int b);
}

//有返回值无参数的功能接口
@FunctionalInterface
interface IHasReturnNoParam {
    int test();
}

//有返回值一个参数的功能接口
@FunctionalInterface
interface IHasReturnOneParam {
    int method(int a);
}

//有返回值两个参数的功能接口
@FunctionalInterface
interface IHasReturnTwoParam {
    int test(int a, int b);
}