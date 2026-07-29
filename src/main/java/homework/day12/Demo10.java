package homework.day12;

import java.util.function.Supplier;

public class Demo10 {
    public static void main(String[] args) {
        // 使用Lambda创建Product对象
        Supplier<Product> lambdaSupplier = () -> new Product("Widget", 9.99);

        // 请用构造方法引用创建相同对象
        Supplier<Product> constructorRef = Product::new;


    }
}
class Product {
    String name;
    double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
@FunctionalInterface
interface ICreate {
    Product create(String name,int price);
}

