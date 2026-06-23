package example1;


import example1.controller.ProductController;
import example1.model.Product;

/**
 * 调用controller中的方法，模拟前端发送请求！！！
 */
public class Main {

    static ProductController controller = new ProductController();


    public static void main(String[] args) {

        // 1. 展示全部商品（Products）页面时，将仅装有商品对象的数组返回，前端不提供任何数据。
        // Product[] allProducts = getAllProducts();
        // for (Product product : allProducts) {
        //     product.printInfo();
        // }

        // 2. 新增商品时
        //  (1) 前端提供商品各种参数
        //  (2) 后端需要校验ID唯一性
        //  (3) 然后将对象插入数组
        //  (4) 返回插入结果(true/false)。
        // insertProduct();

        // 3. 删除商品
        // 删除商品时，前端提供商品ID，
        // 后端将该商品删除后，返回删除结果。（成功返回true，根据ID找不到该商品即删除失败返回false）
        // deleteProductById();

        // 4.查询商品,
        // 前端提供商品ID或者商品名称(可根据ID查询或者根据商品名称查询),
        // 后端根据信息查询商品详情,
        // 并返回结果(商品对象)
        findProductByIdOrName();

        System.out.println();

        // 5. 更新商品
        // 更新商品(每次更新商品中的一个信息即可),
        // 前端提供要被更新的商品ID, 以及新的产品信息,
        // 后端根据商品ID找到该商品, 并将新的信息替换, 返回该商品对象.

        System.out.println("更新前：");
        Product[] allProducts = getAllProducts();
        for (Product product : allProducts) {
            product.printInfo();
        }
        System.out.println();

        System.out.println("更新后：");
        updateProductByIdOrName();

        System.out.println();

        for (Product product : allProducts) {
            product.printInfo();
        }


    }

    // 查询所有的商品
    public static Product[] getAllProducts(){
        Product[] products = controller.findAll();
        return products;
    }

    // 新增商品！
    public static void insertProduct(){

        // 可以通过键盘录入商品的信息
        int id = 2001;
        String name = "VIVO X500";
        double price = 7999;
        String brand = "VIVO";

        boolean ret = controller.insertProduct(id, name, price, brand);
        if (ret) {
            System.out.println("新增商品成功...");
        }else {
            System.out.println("新增商品失败...");
        }

    }

    // 删除商品
    public static void deleteProductById(){

        // 删除商品时，前端提供商品ID，
        // 后端将该商品删除后，返回删除结果。
        // （成功返回true，根据ID找不到该商品即删除失败返回false）
        int id = 2001;

        boolean ret = controller.deleteProductById(id);
        if (ret) {
            System.out.println("删除成功...");
        }else {
            System.out.println("删除失败...");
        }

        // 删除之后，再查询一下删除的结果
        Product[] products = controller.findAll();
        for (Product product : products) {
            if (product != null) {
                product.printInfo();
            }else {
                System.out.println("null");
            }
        }

    }

    // 查询商品
    public static void findProductByIdOrName(){
        int id = 1001;
        String name = "小米";
        Product product1 = controller.findProductByIdOrName(id);
        if(product1 != null){
            product1.printInfo();
        }

        Product product2 = controller.findProductByIdOrName(name);
        if(product2 != null) {
            product2.printInfo();
        }
    }

    // 更新商品
    public static void updateProductByIdOrName(){
        int id = 1001;
        String name = "锤子R1";
        int newId = 2001;
        String newName = "One Plus";

        Product product1 = controller.updateProductIdtById(id, newId);
        if(product1 != null){
            product1.printInfo();
        }

        Product product2 = controller.updateProductNameByName(name, newName);
        if(product2 != null){
            product2.printInfo();
        }
    }
}
