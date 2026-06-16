package test;

abstract class Person {
    // 类，包含成员变量，构造方法，成员方法，给外部提供读取修改成员变量的getXxx和setXxx，
    //     输出全部成员变量信息的tostring，验证相同的equals和hashcode方法，代码块
    String name;
    char sexual;
    int age;
    double height;
    double weight;

    public Person(String name, char sexual, int age, double height, double weight) {
        this.name = name;
        this.sexual = sexual;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Person(String name, char sexual, int age) {
        this.name = name;
        this.sexual = sexual;
        this.age = age;
    }

    public abstract void walk();

    public abstract void eat();

    public abstract void selfIntroduction();

    private boolean isPerson() {
        return true;
    }

}

class Myself extends Person {
    public Myself(String name, char sexual, int age, double height, double weight) {
        super(name, sexual, age, height, weight);
    }

    public Myself(String name, char sexual, int age) {
        super(name, sexual, age);
    }

    @Override
    public String toString() {
        return "Myself{" +
                "name='" + name + '\'' +
                ", sexual=" + sexual +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public void eat() {
        System.out.println(name + "在吃饭");
    }

    @Override
    public void selfIntroduction() {
        System.out.println("你好");
    }

    @Override
    public void walk() {
        System.out.println(name + "在吃饭没在走路");
    }


    public static void main(String[] args) {
        Myself xsc = new Myself("xsc", '男', 23);

        xsc.eat();

        Person xia = new Myself("xia", '?', 999);
        xia.eat();
        System.out.println(xia.toString());
    }
}
