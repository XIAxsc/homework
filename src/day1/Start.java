package day1;

import java.util.Scanner;

public class Start {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("please input month:");
        int month = sc.nextInt();
        if(month > 12 || month < 1){
            System.out.println("wrong month,please try again.");
        }
        else{
            switch (month){
                case 1: case 2: case 12:
                    System.out.println("冬季");
                    break;
                case 3: case 4: case 5:
                    System.out.println("春季");
                    break;
                case 6: case 7: case 8:
                    System.out.println("夏季");
                    break;
                case 9: case 10: case 11:
                    System.out.println("秋季");
                    break;
            }
        }
        /*System.out.println("a=" + a);
        int [] arr = {1,2,3,4,5};
        int [] brr = new int[5];
        for(int i =0 ;i < 5; i++){
            brr[i] = sc.nextInt();
        }
        for(int j = 0;j < 5; j++){
            System.out.print(arr[j]);
        }
        System.out.println(Arrays.toString(brr));
        for(int k:brr){
            System.out.println(k);
        }*/
    }
}