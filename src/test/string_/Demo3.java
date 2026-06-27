package test.string_;

public class Demo3 {
    public static void main(String[] args) {
        String s1 = "kkkkkkk";
        StringBuffer s2 = new StringBuffer(s1);
        int capacity = s2.capacity();
        System.out.println(s2 + " " + capacity);
    }
}
