package main.java.day5;

import java.util.Arrays;

public class _3_real_delete {
    public static void main(String[] args) {
        String[] str = {"abc", "123", "123", "123", "666", "777"};
        int stringLength = str.length;
        str = deleteString(str, "123");

        int deleteLength = stringLength - str.length;

        System.out.println("删除元素后的数组："+Arrays.toString(str));
        System.out.println("一共去掉了" + deleteLength + "个元素");
    }

    public static String[] deleteString(String[] str, String element) {

        int deleteLength = 0;
        for (String i : str) {
            if (element.equals(i)) {
                deleteLength += 1;
            }
        }

        String[] arr = new String[str.length - deleteLength];

        int inde = 0;
        for (String j : str) {
            if (!element.equals(j)) {
                arr[inde] = j;
                inde++;
            }
        }

        return arr;
    }
}
