package com.posteleria.crudApp.Repository;

import java.util.List;

import com.posteleria.crudApp.Model.Product;

public interface ProductRepository {

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);

    List<Product> getAllProducts();

}
