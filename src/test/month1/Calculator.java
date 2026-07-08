package test;

/**
 * 简单计算器，支持加、减、乘、除、平方、幂运算（a 的 n 次方）
 */
public class Calculator {

    /**
     * 通用计算方法
     *
     * @param op     操作符字符串，支持： "+", "-", "*", "/", "square", "pow"
     * @param values 操作数值，根据操作不同需要 1 或 2 个数
     * @return 计算结果
     * @throws IllegalArgumentException 当操作符未知、参数数量不对或除数为零时抛出
     */
    public static double calculator(String op, double... values) {
        switch (op) {
            case "+":
                checkArgCount(op, values, 2);
                return values[0] + values[1];
            case "-":
                checkArgCount(op, values, 2);
                return values[0] - values[1];
            case "*":
                checkArgCount(op, values, 2);
                return values[0] * values[1];
            case "/":
                checkArgCount(op, values, 2);
                if (values[1] == 0.0) {
                    throw new IllegalArgumentException("除数不能为零");
                }
                return values[0] / values[1];
            case "square":   // 求平方
                checkArgCount(op, values, 1);
                double a = values[0];
                return a * a;
            case "pow":      // 求 a 的 n 次方
                checkArgCount(op, values, 2);
                return Math.pow(values[0], values[1]);
            default:
                throw new IllegalArgumentException("不支持的操作符: " + op);
        }
    }

    // 校验参数个数是否正确
    private static void checkArgCount(String op, double[] values, int expected) {
        if (values == null || values.length != expected) {
            throw new IllegalArgumentException(
                    String.format("操作符 '%s' 需要 %d 个参数，实际提供了 %d 个",
                            op, expected, values == null ? 0 : values.length));
        }
    }

    // ---------- 以下为便捷的静态方法（使用 calculator 实现） ----------
    public static double add(double a, double b) {
        return calculator("+", a, b);
    }

    public static double subtract(double a, double b) {
        return calculator("-", a, b);
    }

    public static double multiply(double a, double b) {
        return calculator("*", a, b);
    }

    public static double divide(double a, double b) {
        return calculator("/", a, b);
    }

    public static double square(double a) {
        return calculator("square", a);
    }

    public static double power(double base, double exponent) {
        return calculator("pow", base, exponent);
    }

    // 测试
    public static void main(String[] args) {
        // 演示直接使用 calculator 方法
        System.out.println("2 + 3 = " + calculator("+", 2, 3));
        System.out.println("5 - 2 = " + calculator("-", 5, 2));
        System.out.println("4 * 3 = " + calculator("*", 4, 3));
        System.out.println("10 / 4 = " + calculator("/", 10, 4));
        System.out.println("7 的平方 = " + calculator("square", 7));
        System.out.println("2 的 5 次方 = " + calculator("pow", 2, 5));

        // 演示使用便捷方法
        System.out.println("\n使用便捷方法：");
        System.out.println("add(10, 20) = " + add(10, 20));
        System.out.println("power(3, 4) = " + power(3, 4));
        System.out.println("square(1.5) = " + square(1.5));

        // 异常情况演示（取消注释可测试）
        // System.out.println(calculator("/", 10, 0));    除零异常
        // System.out.println(calculator("pow", 2));      参数不足异常
        // System.out.println(calculator("%", 5, 3));     不支持的操作符
    }
}