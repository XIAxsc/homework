package demos;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CreatePersonInstanceByReflect {
    public static void main(String[] args) {
        try {
            Constructor<Person> constructor = Person.class.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            Person person = constructor.newInstance("张三", 20);
            Method method = Person.class.getDeclaredMethod("getInfo");
            method.setAccessible(true);
            System.out.println(method.invoke(person));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    private int age;

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String getInfo() {
        return "Person{name=" + name + ", age=" + age + "}";
    }
}