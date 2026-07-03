package month1.day18;


import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Demo5 {

    // 使用8个长度是5的随机字符串初始化这个数组
    static void stringInit(String[] s) {
        String POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < s.length; i++) {
            StringBuilder sb = new StringBuilder(5);
            for (int j = 0; j < 5; j++) {
                int idx = ThreadLocalRandom.current().nextInt(POOL.length());
                sb.append(POOL.charAt(idx));
            }
            s[i] = String.valueOf(sb);
        }
        System.out.println("初始化后的字符串：" + Arrays.toString(s));
    }

    private static void bubbleSort(String[] s) {
        StringBuilder[] sb = new StringBuilder[8];
        for (int i = 0; i < s.length; i++) {
            sb[i] = new StringBuilder(s[i]);
            char first = s[i].charAt(0);
            sb[i].append(Character.toLowerCase(first));
        }
        System.out.println("结尾加了小写化的位置：" + Arrays.toString(sb));
        for (int i = 0; i < sb.length; i++) {
            for (int j = 0; j < sb.length - 1 - i; j++) {
                if (sb[j].charAt(sb[j].length() -1) > sb[j + 1].charAt(sb[j].length() -1)) {
                    StringBuilder temp = sb[j];
                    sb[j] = sb[j + 1];
                    sb[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < sb.length; i++) {
            sb[i].deleteCharAt(sb[i].length() - 1);
            s[i] = String.valueOf(sb[i]);
        }
    }

    public static void main(String[] args) {
        String[] test = new String[]{"UxoEl", "If3js", "9SSwC", "czHuA",
                "lZLBF", "IhynX", "VgjrY", "dJAIW"};
        System.out.println("测试用例[UxoEl, If3js, 9SSwC, czHuA, lZLBF, IhynX, VgjrY, dJAIW]");
        bubbleSort(test);
        System.out.println("test排序后：" + Arrays.toString(test) + "\n");

        String[] s = new String[8];
        stringInit(s);

        bubbleSort(s);


        System.out.println("排序后的字符串：" + Arrays.toString(s));
    }
}
