package test.exe;

public class exe1 {
    public static void main(String[] args) {
        byte num1 = 0;
        byte num2 = 0;
        final byte num3 = 10;
        final byte num4 = 20;
        byte result;
        // 下列代码哪行能通过编译，哪行不能？
        // result = num1 + num2;
        result = num3 + num4;
        // result = num1 + num3;
    }
}
