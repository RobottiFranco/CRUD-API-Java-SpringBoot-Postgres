package com.pasteleria.crudApp.Service.impl;

import com.pasteleria.crudApp.Exception.ProductServiceException;
import com.pasteleria.crudApp.Model.Product;
import com.pasteleria.crudApp.Repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
        product.setName("TestProduct");

        productService.addProduct(product);

        verify(productRepository, times(1)).addProduct(product);
    }

    @Test
    public void testAddProductException() {
        Product product = new Product();
        product.setName("TestProduct");

        doThrow(new RuntimeException("Database error")).when(productRepository).addProduct(any(Product.class));

        Exception exception = assertThrows(ProductServiceException.class, () -> {
            productService.addProduct(product);
        });

        assertEquals("Error adding product: Database error", exception.getMessage());
        verify(productRepository, times(1)).addProduct(product);
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setProductId(1);
        product.setName("UpdatedName");

        when(productRepository.getProductById(1)).thenReturn(product);

        productService.updateProduct(product);

        verify(productRepository, times(1)).updateProduct(product);
    }

    @Test
    public void testUpdateProductNotFound() {
        Product product = new Product();
        product.setProductId(1);
        product.setName("UpdatedName");

        when(productRepository.getProductById(1)).thenReturn(null);

        Exception exception = assertThrows(ProductServiceException.class, () -> {
            productService.updateProduct(product);
        });

        assertEquals("Error updating product: Product not found", exception.getMessage());
        verify(productRepository, times(0)).updateProduct(product);
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        product.setProductId(1);

        when(productRepository.getProductById(1)).thenReturn(product);

        productService.deleteProduct(1);

        verify(productRepository, times(1)).deleteProduct(1);
    }

    @Test
    public void testDeleteProductNotFound() {
        when(productRepository.getProductById(1)).thenReturn(null);

        Exception exception = assertThrows(ProductServiceException.class, () -> {
            productService.deleteProduct(1);
        });

        assertEquals("Error deleting product: Product not found", exception.getMessage());
        verify(productRepository, times(0)).deleteProduct(1);
    }

    @Test
    public void testGetAllProducts() {
        Product product = new Product();
        product.setProductId(1);
        product.setName("TestProduct");

        when(productRepository.getAllProducts()).thenReturn(Collections.singletonList(product));

        List<Product> products = productService.getAllProducts();

        assertEquals(1, products.size());
        assertEquals("TestProduct", products.get(0).getName());
        verify(productRepository, times(1)).getAllProducts();
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setProductId(1);
        product.setName("TestProduct");

        when(productRepository.getProductById(1)).thenReturn(product);

        Product retrievedProduct = productService.getProductById(1);

        assertNotNull(retrievedProduct);
        assertEquals("TestProduct", retrievedProduct.getName());
        verify(productRepository, times(1)).getProductById(1);
    }

    @Test
    public void testGetProductByIdNotFound() {
        when(productRepository.getProductById(1)).thenReturn(null);

        Exception exception = assertThrows(ProductServiceException.class, () -> {
            productService.getProductById(1);
        });

        assertEquals("Product not found", exception.getMessage());
        verify(productRepository, times(1)).getProductById(1);
    }
}
