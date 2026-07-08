package test.month2.generics.generics_class;

public class Demo1 {
    public static void main(String[] args) {
        Father<String> f = new Father<>("老王", "牛头人");
    }
}

class Father<T> {
    T name;
    T gender;

    public Father() {
    }

    public Father(T name, T gender) {
        this.name = name;
        this.gender = gender;
    }
}

// 继承时未指定Father泛型的类型，Son1继承的变量都是Object类型
class Son1 extends Father {
    public Son1(Object name, Object gender) {
        super(name, gender);
    }
}

// 继承时指定了Father泛型的类型，但是Son1未定义泛型的类型，所以继承的成员变量是String类型
class Son2 extends Father<String> {
    public Son2(String name, String gender) {
        super(name, gender);
    }
}

// Son3定义时指定了泛型为E，Father泛型为String，所以Son3继承的成员变量为String类型
class Son3<E> extends Father<String> {
    public Son3(String name, String gender) {
        super(name, gender);
    }
}

// 前面<>的是定义泛型，后面<>的是指定泛型类型，Father传入了Son4和Son5一样的类型，父类与子类变量类型一致
class Son4<E> extends Father<E> {
    public Son4(E name, E gender) {
        super(name, gender);
    }
}

class Son5<T> extends Father<T> {
    public Son5(T name, T gender) {
        super(name, gender);
    }
}
