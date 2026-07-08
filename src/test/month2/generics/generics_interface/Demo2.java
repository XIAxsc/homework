package test.month2.generics.generics_interface;

public class Demo2 {
    public static void printInteger(User<? super Integer> user) {
        System.out.println(user.getName() + " -- " + user.getData());
    }

    public static void printObject(User<? extends Object> user) {
        System.out.println(user.getName() + " -- " + user.getData());
    }

    // 泛型不支持协变（即向下兼容，或者说不接受子类），但是可以用通配符<?>来接收任意类型
    public static void print(User<?> user) {
        System.out.println(user.getName() + " -- " + user.getData());
    }

    public static void main(String[] args) {
        User<String> user = new User<>();
        User<Object> objectUser = new User<>();

        printObject(user);                   // <? extends E> 向下限定，接收E及其子类
        printInteger(objectUser);            // <? extends E> 向上限定，接收E及其父类
        print(user);                         // <?>接收任意类型
    }
}

// 泛型接口：指声明接口时使用泛型参数
// 定义泛型：在定义或者说声明什么结构（如Class、Interface等）时附加上了<>即定义泛型，否则只是使用了泛型
interface LIST<T> {
    void add(T element);

    T get(int index);

    int size();
}

