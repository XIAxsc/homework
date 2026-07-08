package test.smalltest;


public class test7 {

    public int sum(int... a) {
        int temp = 0;
        for (int i : a) {
            temp += i;
        }
        return temp;
    }


    public static double kk() {
        return 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("arr1");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println(arr1.length);
        int[] arr2;
        arr2 = arr1;
        System.out.println("arr2");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println(arr2.length);

        int[][] arr3 = new int[3][3];           // arr[]表示一维数组，即二维数组的某一行
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                arr3[i][j] = i * arr3[i].length + j;
            }
        }
        System.out.println("arr3");
        for (int[] ints : arr3) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }


        double k = kk();
        System.out.println("测试：" + k);
    }
}
