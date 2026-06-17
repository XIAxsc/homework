package test.demo;

public class Demo2 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        System.out.println("cat1.age = " + cat1.age);
        cat1.shut();
        Animals cat = new Animals("cat",2);
        System.out.println("cat.toString() = " + cat);
    }
}

class Animals {
    protected String name;
    protected int age = 10;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animals() {
    }

    protected void shut() {
        System.out.println("动物" + name + "在叫");
    }
}

class Cat extends Animals {

    protected int age = 1;

    protected void shut() {
        System.out.println("小猫" + this.name + "在叫");
        super.shut();
    }
}