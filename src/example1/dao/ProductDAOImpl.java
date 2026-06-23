package example1.dao;

import example1.model.Product;
import example1.model.ProductData;

public class ProductDAOImpl implements ProductDAO{

    @Override
    public Product[] queryAll() {
        return ProductData.allProducts;
    }

    @Override
    public void updateAllProducts(Product[] newProducts) {
        ProductData.allProducts = newProducts;
    }
}
