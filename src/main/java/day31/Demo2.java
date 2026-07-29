package main.java.day31;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 过滤出长度大于 3 的字符串；
 * 全部转成大写；
 * 去除重复元素；
 * 最终收集成一个新 List 并遍历打印。
 */
public class Demo2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Python", "Java", "C++", "Go", "JavaScript");

        List<String> newList = list.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .distinct()
                .collect(Collectors.toList());
        newList.forEach(System.out::println);
    }
}
