package test.string;


public class no2 {
    public static void main(String[] args) {
        String str = "";

        StringBuffer sb = new StringBuffer();
        // 获取当前时间戳
        long start = System.currentTimeMillis();
        //int sum = 0;
        //str += "a";
        // sum+=i;
        sb.append("a".repeat(1000000));
        long end = System.currentTimeMillis();
        // 7s
        // 4ms
        System.out.println(end - start);
    }
}