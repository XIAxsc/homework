package homework.Day30;

import java.util.ArrayList;
import java.util.HashMap;

public class Demo2 {
    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        char[] charArray = chars.toCharArray();
        HashMap<String, Integer> map = new HashMap<>();

        for (char c : charArray) {
            int count = 0;
            for (char c1 : charArray) {
                if (c == c1) {
                    count += 1;
                }
            }
            map.put(String.valueOf(c), count);
        }

        ArrayList<String> strings = new ArrayList<>();

        for (String word : words) {
            int flag = 0;
            HashMap<String, Integer> temp = (HashMap<String, Integer>) map.clone();
            char[] wordCharArray = word.toCharArray();
            for (char c : wordCharArray) {
                Integer i = temp.getOrDefault(String.valueOf(c), 0);
                if (i == 0) {
                    flag = 1;
                    break;
                } else {
                    temp.put(String.valueOf(c), temp.get(String.valueOf(c)) - 1);
                }
            }
            if (flag == 0) {
                strings.add(word);
            }
        }
        System.out.println("strings = " + strings);
        int count = 0;
        for (String string : strings) {
            count += string.length();
        }
        System.out.println("count = " + count);
    }
}
