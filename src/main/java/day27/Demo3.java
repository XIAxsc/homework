package day27;

// 泛型不接受基本数据类型！！！
public class Demo3 {
    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Character[] chars = new Character[]{'a', 98, 99, 100};
        String[] strings = new String[]{"我", "系", "渣渣辉", ",", "系", "兄弟", "就来砍我"};
        Demo3Util demo = new Demo3Util();
        demo.printArray(ints);
        demo.printArray(chars);
        demo.printArray(strings);
    }
}

class Demo3Util {
    public <T> void printArray(T[] arrays) {
        System.out.print("[ ");
        for (T array : arrays) {
            System.out.print("" + array + "");
        }

        System.out.println(" ]");
    }
}
