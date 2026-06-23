package example1.service;

import example1.model.Product;

/**
 * 完成业务逻辑，如果需要数据，那么需要通过 dao获取数据
 */
public interface ProductService {

    // 查询所有的商品
    Product[] queryAllProducts();

    // 新增商品
    boolean insertProduct(Product newProduct);

    // 根据商品id删除商品
    boolean deleteProductById(int id);

    // 根据商品id查询商品
    Product findProductByIdOrName(int id);

    // 根据商品name查询商品
    Product findProductByIdOrName(String name);

    // 通过ID查商品并更新商品id信息
    Product updateProductIdtById(int id, int newId);

    // 通过ID查商品并更新商品name信息
    Product updateProductNameById(int id, String newName);

    // 通过ID查商品并更新商品price信息
    Product updateProductPriceById(int id, double newPrice);

    //通过ID查商品并更新商品brand信息
    Product updateProductBrandById(int id, String newBrand);

    // 通过name查询商品并更新商品id信息
    Product updateProductIdByName(String name, int newId);

    // 通过name查商品并更新商品name信息
    Product updateProductNameByName(String name, String newName);

    // 通过name查商品并更新商品price信息
    Product updateProductPriceByName(String name, double newPrice);

    //通过name查商品并更新商品brand信息
    Product updateProductBrandByName(String name, String newBrand);
}
