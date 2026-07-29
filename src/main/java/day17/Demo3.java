package main.java.day17;


public class Demo3 {
    public static void main(String[] args) {
        String string = "peter piper picked a peck of pickled peppers";
        int count = 0;
        String[] strings =  string.split(" ");

        for (String s : strings) {
            if(s.startsWith("p")){
                count++;
            }
        }
        System.out.println("这段绕口令一共有" + count + "个以p开头的单词");
    }
}
