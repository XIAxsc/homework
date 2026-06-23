package example1.dao;

import example1.model.Product;

public interface ProductDAO {

    Product[] queryAll();

    // 更新数据库
    void updateAllProducts(Product[] newProducts);
}
