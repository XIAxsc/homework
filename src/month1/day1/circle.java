package month1.day1;


public class circle {
    public static void main(String[] args) {
        int currentDays;
        int exDays;
        int sumDays = 0;
        currentDays = 31*7+28+4*30;
        exDays = currentDays + 1;
        for(int i = 2000; i < 2008; i++){
            if(i/4*4 == i){
                sumDays += exDays;
            }else sumDays += currentDays;
        }
        System.out.println("2000年1月1日到2008年1月1日相距" + sumDays + "天");
    }
}
