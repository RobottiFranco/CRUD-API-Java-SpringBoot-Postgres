package com.pasteleria.crudApp.Service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasteleria.crudApp.Exception.ProductServiceException;
import com.pasteleria.crudApp.Model.Product;
import com.pasteleria.crudApp.Repository.ProductRepository;
import com.pasteleria.crudApp.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        try {
            productRepository.addProduct(product);
        } catch (Exception e) {
            throw new ProductServiceException("Error adding product: " + e.getMessage());
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            if (productRepository.getProductById(product.getProductId()) == null) {
                throw new ProductServiceException("Product not found");
            }
            productRepository.updateProduct(product);
        } catch (Exception e) {
            throw new ProductServiceException("Error updating product: " + e.getMessage());
        }
    }

    @Override
    public void deleteProduct(int productId) {
        try {
            if (productRepository.getProductById(productId) == null) {
                throw new ProductServiceException("Product not found");
            }
            productRepository.deleteProduct(productId);
        } catch (Exception e) {
            throw new ProductServiceException("Error deleting product: " + e.getMessage());
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            return productRepository.getAllProducts();
        } catch (Exception e) {
            throw new ProductServiceException("Error retrieving products: " + e.getMessage());
        }
    }

    @Override
    public Product getProductById(int productId) {
        try {
            return productRepository.getProductById(productId);
        } catch (Exception e) {
            throw new ProductServiceException("Error retrieving product: " + e.getMessage());
        }
    }
}