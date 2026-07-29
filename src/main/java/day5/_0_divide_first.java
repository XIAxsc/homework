package main.java.day5;

import java.util.Arrays;

public class _0_divide_first {


    public static void main(String[] args) {
        double[] arr = new double[]{2.0,4.0,6.0,4.0};

        divideFirst(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void divideFirst(double[] arr) {

        double temp = arr[0];
        for(int i = 0; i< arr.length;i++){
            arr[i] /= temp;
        }
    }
}
