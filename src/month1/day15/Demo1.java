package month1.day15;

public class Demo1 {
    public static void main(String[] args) {

        // 包装数据全都重写了tostring，hashcode和equals，在代码中改变他们的值其实是指向了新的对象
        // Integer a = 10;
        // System.out.println("a = " + a.hashCode());
        // a = 20;
        // System.out.println("a = " + a.hashCode());

        Integer i = Integer.MAX_VALUE + 1;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        byte b = (byte) (Byte.MAX_VALUE + 1); // byte + int = int（数据类型提升）
        System.out.println(i + "_____" + b);
        System.out.println(max + "\n" +min);
    }
}
