package main.java.day10;

public class Demo2 {
}

// 两个动物的公共部分有名字，年龄和可以叫，所以可以创建有这三项的父类animal给他们继承
class Animal{
    String name;
    int age;

    public void shut(){
        System.out.println(name + "在叫...");
    }
}
class Cat extends Animal{
    String color;

    @Override
    public void shut() {
        System.out.println("小猫" + name + "在喵喵叫...");
    }

    public void catchMouse(){
        System.out.println("小猫" + name + "在抓老鼠...");
    }
}
class Dog extends Animal{
    String gender;

    @Override
    public void shut() {
        System.out.println("小狗" + name + "在汪汪叫...");
    }

    public void guardDoor(){
        System.out.println("小狗" + name + "在看门...");
    }
}
// 如果机器人也会叫有名字和年龄的话也可以用套继承，不过或许用创建一个新的父类继承会更好