package main.java.Day30;

public class Demo1 {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "baedc";
        // char[] tChars = t.toCharArray();
        // for (char c : tChars) {
        //     if(!s.contains(String.valueOf(c))){
        //         System.out.println(c);
        //     }
        // }
        Character theDifference1 = findTheDifference1("qawaqaeaqa", "qaqwaaeqaaa");
        System.out.println("theDifference1 = " + theDifference1);
    }

    public static Character findTheDifference1(String s, String t) {
        int xor = 0;
        for (int i = 0; i < s.length(); i++) {
            xor = xor ^ s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            xor = xor ^ t.charAt(i);
        }
        return (char) xor;
    }
}
