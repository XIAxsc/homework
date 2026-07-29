package homework.day5;

import java.util.Arrays;

public class _2_string_traverse {
    public static void main(String[] args) {

        String[] str = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        System.out.println("第二题，输出该数组的长度：" + str.length);

        traverse1(str);
        traverse2(str);
        traverse3(str);

    }

    public static void traverse1(String[] str) {
        System.out.println("toString方法遍历：" + Arrays.toString(str));
    }

    public static void traverse2(String[] str) {
        System.out.println("普通for循环遍历：");
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();
    }

    public static void traverse3(String[] str) {
        System.out.println("增强for循环遍历：");
        for (String character : str) {
            System.out.print(character + " ");
        }
        System.out.println();
    }
}
