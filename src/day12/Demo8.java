package day12;

public class Demo8 {
    public static void main(String[] args) {
        // 使用匿名内部类实现加法
        MathOperation add = new MathOperation() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };

        // 请用Lambda表达式实现乘法操作（替换下方注释）
        MathOperation multiply = (a,b) -> a * b;

        System.out.println(add.calculate(5, 3));        // 应输出8
        System.out.println(multiply.calculate(5, 3));   // 应输出15
    }
}
interface MathOperation {
    int calculate(int a, int b);
}
