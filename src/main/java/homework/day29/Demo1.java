package homework.day29;

import java.util.ArrayList;
import java.util.Comparator;

public class Demo1 {
    public static void adults(ArrayList<Person> people) {
        for (Person person : people) {
            if (person.age >= 18) {
                System.out.println("adult = " + person);
            }
        }
    }

    public static void upCaseName(ArrayList<Person> people) {
        for (Person person : people) {
            if (person.age >= 18) {
                person.name = person.name.toUpperCase();
                System.out.println("adult = " + person);
            }
        }
    }

    public static void sortByCharacter(ArrayList<Person> people) {
        people.sort(Comparator.comparing(o -> o.name.toUpperCase()));
        System.out.println("people = " + people);
    }

    public static void main(String[] args) {
        Person person1 = new Person("zsf", 199);
        Person person2 = new Person("wym", 90);
        Person person3 = new Person("zwj", 18);
        Person person4 = new Person("xz", 16);
        Person person5 = new Person("zzr", 17);

        ArrayList<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        System.out.println("people = " + people);

        System.out.println("--------------------------");
        System.out.println("年龄大于等于18岁的成年人:");
        adults(people);
        System.out.println("--------------------------");
        System.out.println("年人的名字转换为大写:");
        upCaseName(people);
        System.out.println("--------------------------");
        System.out.println("按照名字的字母顺序进行排序:");
        sortByCharacter(people);
    }
}

class Person {
    String name;
    Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
