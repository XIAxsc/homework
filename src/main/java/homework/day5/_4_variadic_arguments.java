package homework.day5;

public class _4_variadic_arguments {
    public static void main(String[] args) {
        int a = 12;
        int b = 13;
        int c = 123;
        int d = -12;
        int e = 9999;

        int max = getMax(a, b, c, d, e);

        System.out.println("最大值是：" + max);
    }

    public static int getMax(int... num) {
        int max = num[0];
        for (int i : num) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
