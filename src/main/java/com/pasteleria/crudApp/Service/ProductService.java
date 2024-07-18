package com.pasteleria.crudApp.Service;

import java.util.List;

import com.pasteleria.crudApp.Model.Product;

public interface ProductService {
    
    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);

    List<Product> getAllProducts();

    Product getProductById(int productId);

}