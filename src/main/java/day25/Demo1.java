package main.java.day25;

import java.lang.reflect.Field;

public class Demo1 {

    public static void setAll(Object targetObj, String filedName, Object newValue) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = targetObj.getClass();
        Field filed = clazz.getDeclaredField(filedName);
        filed.set(targetObj, newValue);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();

        System.out.println("person = " + person);

        setAll(person, "age", 10);

        System.out.println("person = " + person);
        ;
    }
}

class Person {
    String name;
    Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}