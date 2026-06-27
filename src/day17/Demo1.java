package day17;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1 {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat birth = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date birthday = birth.parse("2003/02/12 03:30:33");
        long now = System.currentTimeMillis();
        long birthL = birthday.getTime();

        long days = (now - birthL) / (1000 * 60 * 60 *24);
        System.out.println("我已经出生了" + days + "天");
    }
}
