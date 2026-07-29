package main.java.day10;

public class Demo5 {
    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new SouthPerson();
        Person p3 = new NorthPerson();
        p1.eat();
        p2.eat();
        p3.eat();
        System.out.println("——————————————————————");

        // 传入SouthPerson对象和NorthPerson对象，并在方法体中调用它们的eat()方法
        SouthPerson sp = new SouthPerson();
        sp.eat();
        // 南方人喜欢吃米饭
        NorthPerson np = new NorthPerson();
        np.eat();
        // 北方人喜欢吃面食
        // 方法调用结果

        // 用父类引用指向子类对象的方式创建SouthPerson对象，能否直接访问salary属性和swim()方法？
        Person s1 = new SouthPerson();
        // s1.salary;
        // s1.swim;
        // 上面两行代码报错，不能访问salary和swim()，因为访问范围由引用类型决定
        // 应该怎么写代码让它能够正常调用？
        // 用引用类型转换，把它转回SouthPerson类型

        // 用父类引用指向子类对象的方式创建NorthPerson对象，能否（直接或写代码）访问salary属性和swim()方法？
        // 不能
        // 如果不能，将该对象引用强转为SouthPerson引用，能否成功？为什么？
        // 不能，因为SouthPerson和NorthPerson没有继承关系，无法强转
        Person s2 = new NorthPerson();
        // s2.salary;
        // s2.swim;
        // SouthPerson sp2 = (SouthPerson) s2;

    }
}
class Person{
    String name;
    int age;
    public void eat(){
        System.out.println("人都要吃饭");
    }
}
class SouthPerson extends Person{
    double salary;

    @Override
    public void eat() {
        System.out.println("南方人喜欢吃米饭");
    }
    public void swim(){
        System.out.println("南方人在游泳");
    }
}
class NorthPerson extends Person{
    double height;

    @Override
    public void eat() {
        System.out.println("北方人喜欢吃面食");
    }
    public void drink(){
        System.out.println("北方人在喝酒");
    }
}
