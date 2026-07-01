package month1.day12;

public class Demo3 {
    public static void main(String[] args) {
        ComputeImpl1 cal1 = new ComputeImpl1();
        // 实现类实现
        System.out.println("实现类实现：");
        System.out.println("cal1.sum(1,2) = " + cal1.sum(1, 2));
        System.out.println("cal1.subtract(3,4) = " + cal1.subtract(3, 4));
        System.out.println("cal1.multiplication(5,6) = " + cal1.multiplication(5, 6));
        System.out.println("cal1.division(7,8) = " + cal1.division(7, 8));

        System.out.println("————————————————————————————————————————————————————————————————");

        // 局部内部类实现
        System.out.println("局部内部类实现：");
        class ComputeImpl2 implements ICompute{
            @Override
            public double sum(double a, double b) {
                return a + b;
            }

            @Override
            public double subtract(double a, double b) {
                return a - b;
            }

            @Override
            public double multiplication(double a, double b) {
                return a * b;
            }

            @Override
            public double division(double a, double b) {
                return a / b;
            }
        }
        ComputeImpl2 cal2 = new ComputeImpl2();
        System.out.println("cal2.sum(1,2) = " + cal2.sum(1, 2));
        System.out.println("cal2.subtract(3,4) = " + cal2.subtract(3, 4));
        System.out.println("cal2.multiplication(5,6) = " + cal2.multiplication(5, 6));
        System.out.println("cal2.division(7,8) = " + cal2.division(7, 8));

        System.out.println("————————————————————————————————————————————————————————————————");

        // 匿名内部类
        ICompute cal3 = new ICompute(){
            @Override
            public double sum(double a, double b) {
                return a + b;
            }

            @Override
            public double subtract(double a, double b) {
                return a - b;
            }

            @Override
            public double multiplication(double a, double b) {
                return a * b;
            }

            @Override
            public double division(double a, double b) {
                return a / b;
            }
        };
        System.out.println("匿名内部类：");
        System.out.println("cal3.sum(1,2) = " + cal3.sum(1, 2));
        System.out.println("cal3.subtract(3,4) = " + cal3.subtract(3, 4));
        System.out.println("cal3.multiplication(5,6) = " + cal3.multiplication(5, 6));
        System.out.println("cal3.division(7,8) = " + cal3.division(7, 8));
    }
}
interface ICompute{
    double sum(double a,double b);
    double subtract(double a, double b);
    double multiplication(double a, double b);
    double division(double a, double b);
}
class ComputeImpl1 implements ICompute{
    @Override
    public double sum(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) {
        return a * b;
    }

    @Override
    public double division(double a, double b) {
        return a / b;
    }
}
