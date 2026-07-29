package main.java.day18;

public class Demo2 {
    public static void main(String[] args) {
        String s = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        int index = 0;
        int count = 0;
        while(index < s.length()) {
            index = s.indexOf("java",index);
            if(index != -1){
                count++;
                index += 3;
            }
            else break;
        }
        System.out.println("java出现了" + count + "次");
    }
}
