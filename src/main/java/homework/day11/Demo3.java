package homework.day11;

public class Demo3 {
}
class Animals{
    int t;
}
class Dog extends Animals{
    int d;
}
class Father {
    int f;

    public int m1(){
        return 0;
    }

    public Animals m2(){
        return null;
    }
}
class Son extends Father{
    int s;

    @Override
    public int m1() {
        return super.m1();
    }

    // @Override
    // public double m1() {
    //     return super.m1();
    // }

    @Override
    public Dog m2() {
        return null;
    }

    // @Override
    // public Animals m2() {
    //     return null;
    // }
}
