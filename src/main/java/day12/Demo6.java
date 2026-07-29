package main.java.day12;

public class Demo6 {
    public static void main(String[] args) {
        Compute cSum = Double::sum;
        Compute cSubtract = (a, b) -> a - b;
        Compute cMultiplication = (a, b) -> a * b;
        Compute cDivision = (a, b) -> a / b;


        System.out.println("1 + 2 = " + ComputeTool.calc(cSum, 1, 2));
        System.out.println("3 - 4 = " + ComputeTool.calc(cSubtract, 3, 4));
        System.out.println("5 * 6 = " + ComputeTool.calc(cMultiplication, 5, 6));
        System.out.println("7 / 8 = " + ComputeTool.calc(cDivision, 7, 8));
    }
}

@FunctionalInterface
interface Compute {
    double compute(double a, double b);
}

// 工具类和工具方法如下：
// 需要提供一个使用功能接口的方法完成需求
class ComputeTool {
    private ComputeTool() {
    }

    public static double calc(Compute com, double a, double b) {
        return com.compute(a, b);
    }
}