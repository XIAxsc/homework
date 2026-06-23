package example1.model;

/**
 * 这个类，用来模拟数据库中的数据！
 */
public class ProductData {

    // 商品数组，用来表示所有的商品
    public static Product[] allProducts;

    static {

        allProducts = new Product[5];

        Product p1 = new Product(1001, "小米15", 3999, "小米");
        Product p2 = new Product(1002, "苹果16", 6999, "苹果");
        Product p3 = new Product(1003, "三星20", 5999, "三星");
        Product p4 = new Product(1004, "锤子R1", 2999, "锤子");
        Product p5 = new Product(1005, "华为Mate 90", 9999, "华为");

        allProducts[0] = p1;
        allProducts[1] = p2;
        allProducts[2] = p3;
        allProducts[3] = p4;
        allProducts[4] = p5;
    }


}
