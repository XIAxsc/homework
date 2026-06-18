package day10;

public class Demo6 {
}
class Mother{
    int a;

    public Mother() {
    }

    public Mother(int a) {
        this.a = a;
    }

    public Mother m1(){
        System.out.println("执行m1方法...");
        return new Mother(114);
    }
}
class Daughter extends Mother{
    public Daughter() {
    }
    public Daughter(int a) {
        super(a);
    }

    @Override
    public Daughter m1() {
        return new Daughter(514);
    }
}