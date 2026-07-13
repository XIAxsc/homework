package month2.Day30;

import java.util.HashMap;
import java.util.Set;

public class Demo3 {
    public static void main(String[] args) {
        // String s = "aababcabcdabcde";
        String s = "qawaqaeaqa";
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Character> characters = map.keySet();
        for (Character character : characters) {
            System.out.print(character + "(" + map.get(character) + ")");
        }
    }
}
