package test.string;

import java.util.Arrays;

public class Demo4 {
    public static void main(String[] args) {
        String s = "abaabac12031231ud019u11sj109s1w0d8h0ahd01hw09ajd091j901jd091wjd0qj9wj0x9019dw1wd1";
        char[] chars1 = s.toCharArray();
        char[] chars2 = s.toCharArray();

        String s1 = "男";
        String s2 = "女";
        int a = s1.compareTo(s2);
        int b = s2.compareTo(s1);
        System.out.println(a);
        System.out.println("输出a的值：" + a + "\n" + "输出b的值：" + b);

        System.out.println("排序前：" + s);
        System.out.println(Arrays.toString(chars1));

        long start1 = System.currentTimeMillis();
        Arrays.sort(chars1);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        bubbleSort(chars2);
        long end2 = System.currentTimeMillis();

        System.out.println("排序后：" + new String(chars1));
        System.out.println(Arrays.toString(chars2));
        System.out.println("end1 - start1 = " + (end1 - start1));
        System.out.println("end2 - start2 = " + (end2 - start2));

        System.out.println(4 << 10);

    }

    private static void bubbleSort(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length - 1 - i; j++) {
                if(chars[j] > chars[j + 1]){
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }

            }

        }
    }
}
