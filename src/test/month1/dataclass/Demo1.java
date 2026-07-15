package test.month1.dataclass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        Date now = new Date();
        System.out.println("now = " + now);

        Date birth = new Date(1044979408);
        System.out.println("birth = " + birth);
        long nowML = now.getTime();
        System.out.println("nowML = " + nowML);
        System.out.println(new Date(nowML));

        SimpleDateFormat a = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date date = a.parse("2003/02/12 03:30:30");
        System.out.println("date = " + date.getTime());
        System.out.println(a.parse(a.format(birth)));
    }
}