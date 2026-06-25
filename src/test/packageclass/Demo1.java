package test.packageclass;

public class Demo1 {
    public static void main(String[] args) {
        int a = 10;
        // 手动装箱即将被废弃
        // integer的缓存大小为256，范围-128~127,0号位置是-128
        Integer integer = new Integer(a);
        Integer integer2 = 20;
        Integer integer1 = a;


        System.out.println("integer = " + integer.describeConstable());
        System.out.println("integer1 = " + integer1);
        System.out.println("integer2 = " + integer2);

        // 自动装箱
        Double b = 30.0;
        // 自动拆箱
        double bb = b;
        String c = Double.toString(b);
        System.out.println(c);
        b.isNaN();
    }





}

