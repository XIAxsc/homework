package homework.day3;

public class find_different {
    public static void main(String[] args) {
        //假设题目给出的三个值是int类型
        // Scanner sc = new Scanner(System.in);
        // System.out.println("接下来请输入三个int型的值，其中两个值必须相同。");
        // System.out.print("请输入a的值：");
        // int a = sc.nextInt();
        // System.out.print("请输入b的值：");
        // int b = sc.nextInt();
        // System.out.print("请输入c的值：");
        // int c = sc.nextInt();
        //
        // if(a == b){
        //     System.out.println("第三个不同的变量是c = " + c);
        // }else if(b == c){
        //     System.out.println("第三个不同的变量是a = " + a);
        // }else {
        //     System.out.println("第三个不同的变量是b = " + b);
        // }
        int a = 10;
        int b = 10;
        int c = 100;
        int result = a^b^c;
        System.out.println(result);
        //两个相同的数^（异或）操作结果为0,0与另一个数异或为另一个数本身
    }
}
