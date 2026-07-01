package test.string;

public class Demo2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        String s = "abcbabcbabcbabc";
        String s1 = new String("abc");
        System.out.println(s + s1);

        char c = s.charAt(1);
        System.out.println("c = " + c);

        int fromIndex = 0;
        int count = 0;
        while ( (fromIndex = s.indexOf("abc",fromIndex)) != -1){
            count += 1;
            fromIndex++;
        }
        System.out.println("count = " + count);

        String ss = "ss";
        String sss = "ss";
        System.out.println(ss == sss);                  // true

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
