package test.demo;

public class Demo1 {
    public static void main(String[] args) {
        Son s = new Son();
        Son s2 = new Son(300);
        Father fs = new Son();
        Father f = new Father();
        System.out.println("s.getNum() = " + s.getNum());
        System.out.println("s2.getNum() = " + s2.getNum());
        System.out.println("fs.getNum() = " + fs.getNum());
        System.out.println("f.getNum() = " + f.getNum());
    }
}

class Father {
    int num = 100;

    public int getNum() {
        return num;
    }

    public Father() {
        // 该行在执行时,如果创建的是子类对象,
        // 那么子类的任何赋值手段都没有执行,那子类中的num一定是0
        System.out.println(getNum());
    }

}

class Son extends Father {
    int num = 200;

    @Override
    public int getNum() {
        return num;
    }

    public Son() {
        super();
    }

    public Son(int num) {
        this.num = num;
    }
}