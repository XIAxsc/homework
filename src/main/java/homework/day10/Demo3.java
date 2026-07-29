package homework.day10;

public class Demo3 {
    final int a = 1;
    final int b;
    final int c;
    final static int A = 100;
    final static int B;

    public Demo3(int b) {
        this.b = b;
    }
    {
        this.c = 10;
    }
    static{
        B = 20;
    }

    @Override
    public String toString() {
        return "Demo3{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("Demo3.A = " + Demo3.A);
        System.out.println("Demo3.B = " + Demo3.B);
        Demo3 d3 = new Demo3(2);
        System.out.println(d3);
    }
}
