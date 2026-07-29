package homework.Day28;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        ArrayList<Goods> shoppingCart = new ArrayList<>();
        while (true) {
            System.out.println("1.输入delete进入删除功能\n2.输入display显示学生名单\n3.输入quit退出程序\n请输入商品名称：");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if ("quit".equals(s)) break;
            else if ("delete".equals(s)) {
                System.out.println("请输入要删除的商品的名称：");
                String deleteString = sc.nextLine();
                Iterator<Goods> iterator = shoppingCart.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().name.equals(deleteString)) {
                        iterator.remove();
                        System.out.println("删除成功！");
                    }
                }
            } else if ("display".equals(s)) {
                System.out.println("当前购物车内容如下：" + shoppingCart);
            } else {
                System.out.println("请输入商品价格：");
                String price = sc.nextLine();
                shoppingCart.add(new Goods(s, Double.parseDouble(price)));
                System.out.println("加入购物车成功");
            }
        }

    }
}

class Goods {
    String name;
    Double price;

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
