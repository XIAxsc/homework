package example1.service.impl;

import example1.dao.ProductDAO;
import example1.dao.ProductDAOImpl;
import example1.model.Product;
import example1.service.ProductService;

public class ProductServiceImpl implements ProductService {

    ProductDAO productDAO = new ProductDAOImpl();

    // 查询所有的商品
    @Override
    public Product[] queryAllProducts() {
        return productDAO.queryAll();
    }

    // 新增商品
    @Override
    public boolean insertProduct(Product newProduct) {


        // 1. 校验商品id的唯一性
        int currentId = newProduct.getId();
        Product[] allProducts = productDAO.queryAll();      // 获取所有的商品
        for (Product p : allProducts) {                     // 挨个遍历
            if (currentId == p.getId()) {                   // 判断id是否一致
                System.out.println("商品id重复了...");
                return false;
            }
        }

        // 2. 把商品添加到数组中
        // (1) 先找数组中是否有空位置
        int index = -1;
        for (int i = 0; i < allProducts.length; i++) {
            if (allProducts[i] == null) {
                index = i;
                break;
            }
        }
        // (2) 如果有空位置，那么直接把添加的元素放入到空位置
        if (index != -1) {
            allProducts[index] = newProduct;
            return true;
        }

        // (3) 如果没有空位置，那么创建新的数组，长度 + 1，并且把新元素放到新数组的最后一个位置
        Product[] newProducts = new Product[allProducts.length + 1];
        System.arraycopy(allProducts, 0, newProducts, 0, allProducts.length);
        newProducts[newProducts.length - 1] = newProduct;

        // 记得更新数据库
        productDAO.updateAllProducts(newProducts);

        // 3. 返回结果
        return true;
    }

    // 根据商品id删除商品
    @Override
    public boolean deleteProductById(int id) {

        // 1. 校验商品id是否存在
        Product[] products = productDAO.queryAll();
        boolean exists = false;
        for (Product product : products) {
            if (product != null && id == product.getId()) {
                exists = true;
            }
        }

        // 2. 如果不存在，那么直接提示，并且返回
        if (!exists) {
            System.out.println("商品id不存在...");
            return false;
        }

        // 3. 如果存在，那么删除
        // for (int i = 0; i < products.length; i++) {
        //     if (products[i] != null && products[i].getId() == id) {
        //         products[i] = null;
        //         return true;
        //     }
        // }

        // 删除，不置为null的办法
        Product[] newProducts = new Product[products.length - 1];
        int i = 0;      // 老数组的指针
        int j = 0;      // 新数组的指针
        for ( ;i < products.length; ) {
            if (products[i].getId() == id) {
                // 跳过赋值
                i++;
                continue;
            }else {
                newProducts[j] = products[i];
                i++;
                j++;
            }
        }
        productDAO.updateAllProducts(newProducts);

        return true;
    }

    // 通过商品id查询商品
    @Override
    public Product findProductByIdOrName(int id) {
        Product[] products = productDAO.queryAll();
        for (Product product : products) {
            if(id == product.getId()){
                return product;
            }
        }
        System.out.println("数据库中没有id为" + id + "的商品");
        return null;
    }

    // 通过商品name查询商品
    @Override
    public Product findProductByIdOrName(String name) {
        Product[] products = productDAO.queryAll();
        for (Product product : products) {
            if(name.equals(product.getName())){
                return product;
            }
        }
        System.out.println("数据库中没有名为" + name + "的商品");
        return null;
    }

    // 通过id查商品并更新商品id信息
    @Override
    public Product updateProductIdtById(int id, int newId) {
        Product[] products = productDAO.queryAll();
        for (Product product : products) {
            if (product.getId() == id) {
                product.setId(newId);
                productDAO.updateAllProducts(products);
                return product;
            }
        }
        System.out.println("数据库中没有id为" + id + "的商品");
        return null;
    }

    // 通过ID查商品并更新商品name信息
    @Override
    public Product updateProductNameById(int id, String newName) {
        Product[] products = productDAO.queryAll();
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(newName);
                productDAO.updateAllProducts(products);
                return product;
            }
        }
        System.out.println("数据库中没有id为" + id + "的商品");
        return null;
    }

    // 通过id查商品并更新商品price信息
    @Override
    public Product updateProductPriceById(int id, double newPrice) {
        Product[] products = productDAO.queryAll();
        for (Product product : products) {
            if (product.getId() == id) {
                product.setPrice(newPrice);
                productDAO.updateAllProducts(products);
                return product;
            }
        }
        System.out.println("数据库中没有id为" + id + "的商品");
        return null;
    }

    //通过ID查商品并更新商品brand信息
    @Override
    public Product updateProductBrandById(int id, String newBrand) {
        Product[] products = productDAO.queryAll();
        for (Product product : products) {
            if (product.getId() == id) {
                product.setBrand(newBrand);
                productDAO.updateAllProducts(products);
                return product;
            }
        }
        System.out.println("数据库中没有id为" + id + "的商品");
        return null;
    }

    // 通过name查询商品并更新商品id信息
    @Override
    public Product updateProductIdByName(String name, int newId) {
        Product[] products = productDAO.queryAll();
        for (Product product : products) {
            if (name.equals(product.getName())) {
                product.setId(newId);
                productDAO.updateAllProducts(products);
                return product;
            }
        }
        System.out.println("数据库中没有name为" + name + "的商品");
        return null;
    }

    // 通过name查商品并更新商品name信息
    @Override
    public Product updateProductNameByName(String name, String newName) {
        Product[] products = productDAO.queryAll();
        for (Product product : products) {
            if (name.equals(product.getName())) {
                product.setName(newName);
                productDAO.updateAllProducts(products);
                return product;
            }
        }
        System.out.println("数据库中没有name为" + name + "的商品");
        return null;
    }

    // 通过name查商品并更新商品price信息
    @Override
    public Product updateProductPriceByName(String name, double newPrice) {
        Product[] products = productDAO.queryAll();
        for (Product product : products) {
            if (name.equals(product.getName())) {
                product.setPrice(newPrice);
                productDAO.updateAllProducts(products);
                return product;
            }
        }
        System.out.println("数据库中没有name为" + name + "的商品");
        return null;
    }

    //通过name查商品并更新商品brand信息
    @Override
    public Product updateProductBrandByName(String name, String newBrand) {
        Product[] products = productDAO.queryAll();
        for (Product product : products) {
            if (name.equals(product.getName())) {
                product.setBrand(newBrand);
                productDAO.updateAllProducts(products);
                return product;
            }
        }
        System.out.println("数据库中没有name为" + name + "的商品");
        return null;
    }
}
