package month1.day12;


public class Demo9 {
    public static void main(String[] args) {
        // 使用匿名内部类实现首字母大写
        Printer.printFormatted("hello", new StringFormatter() {
            @Override
            public String format(String s) {
                return s.substring(0, 1).toUpperCase() + s.substring(1);
            }
        });

        // 请用Lambda表达式实现反转字符串
        Printer.printFormatted("world", (s) -> {

                char[] c = s.toCharArray();
                char[] c1 = new char[c.length];
                for (int i = 0; i < c.length; i++) {
                    c1[c.length - i -1] = c[i];
                }
                return String.valueOf(c1);
        }
        );

        // 请用方法引用实现转大写
        Printer.printFormatted("java", Printer::toUp);
        Printer.printFormatted("java", String::toUpperCase);
    }
}
@FunctionalInterface
interface StringFormatter {
    String format(String s);
}

class Printer {
    public static void printFormatted(String s, StringFormatter formatter) {
        System.out.println(formatter.format(s));
    }

    public static String toUp(String s){
        return s.toUpperCase();
    }
}




