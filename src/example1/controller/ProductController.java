package example1.controller;

import example1.model.Product;
import example1.service.ProductService;
import example1.service.impl.ProductServiceImpl;

/**
 * 商品的控制器，用来接收前端的请求，分发请求（其实就是调用Service中的方法）
 */
public class ProductController {

    ProductService service = new ProductServiceImpl();


    // 1. 查询所有的商品
    public Product[] findAll(){

        return service.queryAllProducts();
    }


    // 2. 新增商品
    public boolean insertProduct(int id, String name, double price, String brand){

        // (1) 基本的参数校验
        if (price <= 0) {
            System.out.println("价格非法！");
            return false;
        }

        if (name == null || name.length() == 0) {
            System.out.println("商品名字不合法!!");
            return false;
        }

        // (2) 调用service中的方法，完成业务逻辑！
        Product newProduct = new Product(id, name, price, brand);
        return service.insertProduct(newProduct);
    }

    // 删除商品
    public boolean deleteProductById(int id) {

        // 1. 校验id是否合法
        if (id <= 0) {
            System.out.println("商品id不合法!");
            return false;
        }

        // 2. 调用service中的方法，完成业务逻辑
        return service.deleteProductById(id);

    }

    // 通过ID查商品
    public Product findProductByIdOrName(int id) {
        // 1. 校验id是否合法
        if (id <= 0) {
            System.out.println("商品id不合法!");
            return null;
        }

        // 2. 调用service中的方法，完成业务逻辑
        return service.findProductByIdOrName(id);
    }

    // 通过name查商品
    public Product findProductByIdOrName(String name) {
        // 1. 校验商品name是否合法
        if(name == null || name.isEmpty()){
            System.out.println("商品name不合法!");
            return null;
        }

        // 2.调用service中的方法，完成业务逻辑
        return service.findProductByIdOrName(name);
    }

    // 通过ID查商品并更新商品id信息
    public Product updateProductIdtById(int id, int newId) {
        // 1. 校验id是否合法
        if (id <= 0) {
            System.out.println("商品id不合法!");
            return null;
        }
        if (newId <= 0) {
            System.out.println("新商品id不合法!");
            return null;
        }

        // 2.调用service中的方法，完成业务逻辑
        return service.updateProductIdtById(id, newId);
    }

    // 通过ID查商品并更新商品name信息
    public Product updateProductNameById(int id, String newName) {
        // 1. 校验id是否合法
        if (id <= 0) {
            System.out.println("商品id不合法!");
            return null;
        }
        if(newName == null || newName.isEmpty()){
            System.out.println("新商品name不合法!");
            return null;
        }

        // 2.调用service中的方法，完成业务逻辑
        return service.updateProductNameById(id, newName);
    }

    // 通过ID查商品并更新商品price信息
    public Product updateProductPriceById(int id, double price) {
        // 1. 校验id是否合法
        if (id <= 0) {
            System.out.println("商品id不合法!");
            return null;
        }
        if (price <= 0) {
            System.out.println("新商品price不合法!");
            return null;
        }

        // 2.调用service中的方法，完成业务逻辑
        return service.updateProductPriceById(id, price);
    }

    //通过ID查商品并更新商品brand信息
    public Product updateProductBrandById(int id, String newBrand) {
        // 1. 校验id是否合法
        if (id <= 0) {
            System.out.println("商品id不合法!");
            return null;
        }
        if(newBrand == null || newBrand.isEmpty()){
            System.out.println("新商品brand不合法!");
            return null;
        }

        // 2.调用service中的方法，完成业务逻辑
        return service.updateProductBrandById(id, newBrand);
    }

    // 通过name查询商品并更新商品id信息
    public Product updateProductIdByName(String name, int newId) {
        // 1. 校验商品name是否合法
        if(name == null || name.isEmpty()){
            System.out.println("商品name不合法!");
            return null;
        }
        if(newId <= 0){
            System.out.println("商品新id不合法!");
            return null;
        }
        return service.updateProductIdByName(name, newId);
    }

    // 通过name查商品并更新商品name信息
    public Product updateProductNameByName(String name, String newName) {
        // 1. 校验商品name是否合法
        if(name == null || name.isEmpty()){
            System.out.println("商品name不合法!");
            return null;
        }
        if(newName == null || newName.isEmpty()){
            System.out.println("新商品name不合法!");
            return null;
        }

        return service.updateProductNameByName(name, newName);
    }

    // 通过name查商品并更新商品price信息
    public Product updateProductPriceByName(String name, double price) {
        // 1. 校验商品name是否合法
        if(name == null || name.isEmpty()){
            System.out.println("商品name不合法!");
            return null;
        }
        if (price <= 0) {
            System.out.println("新商品price不合法!");
            return null;
        }

        // 2.调用service中的方法，完成业务逻辑
        return service.updateProductPriceByName(name, price);
    }

    //通过name查商品并更新商品brand信息
    public Product updateProductBrandByName(String name, String newBrand) {
        // 1. 校验商品name是否合法
        if(name == null || name.isEmpty()){
            System.out.println("商品name不合法!");
            return null;
        }
        if(newBrand == null || newBrand.isEmpty()){
            System.out.println("新商品brand不合法!");
            return null;
        }

        // 2.调用service中的方法，完成业务逻辑
        return service.updateProductBrandByName(name, newBrand);
    }
}
