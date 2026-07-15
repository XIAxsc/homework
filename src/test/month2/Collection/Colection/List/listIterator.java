package test.month2.Collection.Colection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class listIterator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "张三", "haha", "nice");

        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
