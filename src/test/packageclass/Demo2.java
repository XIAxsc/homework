package test.packageclass;

public class Demo2 {
    public static void main(String[] args) {
        Double d = 33.33;
        d = 22.22;
        System.out.println(d);

        // Object obj1 = true ? new Integer(1):new Double(2.0);
        // System.out.println(obj1);
        // 1.0  三目运算符取决于最大范围的double

        Object obj2;
        // if(true)
        //     obj2 = new Integer(1);
        // else
        //     obj2 = new Double(2.0);
        // System.out.println(obj2);
        // 1 跟上面那个不一样,这是if语句

        // Integer i1 = new Integer(127);
        // Integer i2 = new Integer(127);
        // System.out.println(i1 == i2);
        // false
        // Integer i3 = new Integer(128);
        // Integer i4 = new Integer(128);
        // System.out.println(i3 == i4);
        // false 对象地址不一样


    }
}

