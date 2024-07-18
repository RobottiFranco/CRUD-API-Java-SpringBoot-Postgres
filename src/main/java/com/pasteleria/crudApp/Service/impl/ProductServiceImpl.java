package com.pasteleria.crudApp.Service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasteleria.crudApp.Model.Product;
import com.pasteleria.crudApp.Repository.ProductRepository;
import com.pasteleria.crudApp.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteProduct(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}