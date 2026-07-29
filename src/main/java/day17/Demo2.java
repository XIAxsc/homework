package main.java.day17;

/**
 *  1. 字符串常量池位置（栈内存？ 堆内存？ 方法区 ？本地方法栈 ？）
 *  2.以下哪种方式会直接将字符串放入常量池？
 *      A. String s = new String("abc");
 *      B. String s = "abc";
 *      C. String s = new String(new char[]{'a','b','c'});
 *  3. 以下代码的输出结果是什么？
 */

public class Demo2 {
    public static void main(String[] args) {
        // String s1 = "java";
        // String s2 = "java";
        // System.out.println(s1 == s2);
        // true


        // String s1 = "hello";
        // String s2 = new String("hello");
        // System.out.println(s1 == s2);
        // false


        // String s1 = "abc";
        // String s2 = "a" + "b" + "c";
        // System.out.println(s1 == s2);
        // true


        // String s1 = "abc";
        // String s2 = "ab";
        // String s3 = s2 + "c";
        // System.out.println(s1 == s3);
        // false



        // final String s1 = "ab";
        // String s2 = s1 + "c";
        // String s3 = "abc";
        // System.out.println(s2 == s3);
        // true


        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + s2;
        String s4 = s1 + "b";
        String s5 = "a" + "b";
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        // false，false
    }
}
