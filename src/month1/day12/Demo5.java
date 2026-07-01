package month1.day12;

public class Demo5 {
    public static void main(String[] args) {
        ICreator ic = Person::new;
        Person person = ic.create("张三",20);
        System.out.println(person.name+person.age+"岁了");
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

interface ICreator {
    Person create(String name, int age);
}