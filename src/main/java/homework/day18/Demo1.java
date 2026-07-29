package homework.day18;

public class Demo1 {
    public static void main(String[] args) {
        String s = "legendary";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if((i + 1) % 2 != 0){
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        s = String.valueOf(chars);
        System.out.println("s = " + s);
    }
}
