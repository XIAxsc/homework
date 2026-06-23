package day12;

public class Demo2 {
}
class Test{
    public static void main(String[] args){
        //(1)创建并初始化Bean1类对象bean1
        Test.Bean1 bean1 = new Test().new Bean1();
        bean1.i++;
        //(2)创建并初始化Bean2类对象bean2
        Bean2 bean2 = new Bean2();
        bean2.j++;
        //(3)创建并初始化Bean3类对象bean3
        Bean.Bean3 bean3 = new Bean().new Bean3();
        bean3.k++;

        // System.out.println("bean1.i = " + bean1.i);
        // System.out.println("bean2.j = " + bean2.j);
        // System.out.println("bean3.k = " + bean3.k);
    }
    class Bean1{
        public int i = 0;
    }
    static class Bean2{
        public int j = 0;
    }
}
class Bean{
    class Bean3{
        public int k = 0;
    }
}