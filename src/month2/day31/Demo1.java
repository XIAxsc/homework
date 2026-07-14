package month2.day31;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "iPhone 15", 6999.00));
        productList.add(new Product(2, "Samsung Galaxy S24", 5999.00));
        productList.add(new Product(3, "Sony WH-1000XM5", 1999.00));
        productList.add(new Product(4, "Apple Watch Series 9", 3199.00));
        productList.add(new Product(5, "MacBook Pro 14", 16999.00));

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1001, List.of(1, 3), 6999.00 + 1999.00));
        orderList.add(new Order(1002, List.of(2, 4, 5), 5999.00 + 3199.00 + 16999.00));
        orderList.add(new Order(1003, List.of(5), 16999.00));

        System.out.println("=== 商品列表 ===");
        for (Product product : productList) {
            System.out.println(product);
        }
        System.out.println("\n=== 订单列表及详细信息 ===");
        for (Order order : orderList) {
            System.out.println(order);
            List<Product> products = order.productList(productList);
            products.forEach(System.out::println);
            System.out.println("--------------");
        }
    }
}

class Product {
    Integer id;
    String name;
    Double price;

    public Product(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Order {
    Integer id;
    List<Integer> productIds;

    Double price;

    public Order(Integer id, List<Integer> productIds, Double price) {
        this.id = id;
        this.productIds = productIds;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productIds=" + productIds +
                ", price=" + price +
                '}';
    }

    public List<Product> productList(List<Product> products) {
        return productIds.stream()
                .map(id -> products.stream()
                                .filter(product -> product.id.equals(id))
                                .findFirst().get()
                        // for (Product product : products) {
                        //     if (product.id.equals(id)) {
                        //         return product;
                        //     }
                        // }
                        // return null;
                )
                .collect(Collectors.toList());
        // return productIds.stream()
        //         .map(new Function<Integer, Product>() {
        //             @Override
        //             public Product apply(Integer id) {
        //                 for (Product product : products) {
        //                     if (product.id.equals(id)) {
        //                         return product;
        //                     }
        //                 }
        //                 return null;
        //             }
        //         })
        //         .collect(Collectors.toList());
    }
}
