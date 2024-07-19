package com.pasteleria.crudApp.Service.impl;

import com.pasteleria.crudApp.Exception.ProductTypeServiceException;
import com.pasteleria.crudApp.Model.ProductType;
import com.pasteleria.crudApp.Repository.ProductTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProductTypeServiceImplTest {

    @Mock
    private ProductTypeRepository productTypeRepository;

    @InjectMocks
    private ProductTypeServiceImpl productTypeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddProductType() {
        ProductType productType = new ProductType();
        productType.setName("TestType");

        productTypeService.addProductType(productType);

        verify(productTypeRepository, times(1)).addProductType(productType);
    }

    @Test
    public void testAddProductTypeException() {
        ProductType productType = new ProductType();
        productType.setName("TestType");

        doThrow(new RuntimeException("Database error")).when(productTypeRepository)
                .addProductType(any(ProductType.class));

        Exception exception = assertThrows(ProductTypeServiceException.class, () -> {
            productTypeService.addProductType(productType);
        });

        assertEquals("Error adding product type: Database error", exception.getMessage());
        verify(productTypeRepository, times(1)).addProductType(productType);
    }

    @Test
    public void testUpdateProductType() {
        ProductType productType = new ProductType();
        productType.setProductTypeId(1);
        productType.setName("UpdatedName");

        when(productTypeRepository.getProductTypeById(1)).thenReturn(productType);

        productTypeService.updateProductType(productType);

        verify(productTypeRepository, times(1)).updateProductType(productType);
    }

    @Test
    public void testUpdateProductTypeNotFound() {
        ProductType productType = new ProductType();
        productType.setProductTypeId(1);
        productType.setName("UpdatedName");

        when(productTypeRepository.getProductTypeById(1)).thenReturn(null);

        Exception exception = assertThrows(ProductTypeServiceException.class, () -> {
            productTypeService.updateProductType(productType);
        });

        assertEquals("Error updating product type: Product type not found", exception.getMessage());
        verify(productTypeRepository, times(0)).updateProductType(productType);
    }

    @Test
    public void testDeleteProductType() {
        ProductType productType = new ProductType();
        productType.setProductTypeId(1);

        when(productTypeRepository.getProductTypeById(1)).thenReturn(productType);

        productTypeService.deleteProductType(1);

        verify(productTypeRepository, times(1)).deleteProductType(1);
    }

    @Test
    public void testDeleteProductTypeNotFound() {
        when(productTypeRepository.getProductTypeById(1)).thenReturn(null);

        Exception exception = assertThrows(ProductTypeServiceException.class, () -> {
            productTypeService.deleteProductType(1);
        });

        assertEquals("Error deleting product type: Product type not found", exception.getMessage());
        verify(productTypeRepository, times(0)).deleteProductType(1);
    }

    @Test
    public void testGetAllProductTypes() {
        ProductType productType = new ProductType();
        productType.setProductTypeId(1);
        productType.setName("TestType");

        when(productTypeRepository.getAllProductTypes()).thenReturn(Collections.singletonList(productType));

        List<ProductType> productTypes = productTypeService.getAllProductTypes();

        assertEquals(1, productTypes.size());
        assertEquals("TestType", productTypes.get(0).getName());
        verify(productTypeRepository, times(1)).getAllProductTypes();
    }

    @Test
    public void testGetProductTypeById() {
        ProductType productType = new ProductType();
        productType.setProductTypeId(1);
        productType.setName("TestType");

        when(productTypeRepository.getProductTypeById(1)).thenReturn(productType);

        ProductType retrievedProductType = productTypeService.getProductTypeById(1);

        assertNotNull(retrievedProductType);
        assertEquals("TestType", retrievedProductType.getName());
        verify(productTypeRepository, times(1)).getProductTypeById(1);
    }

    @Test
    public void testGetProductTypeByIdNotFound() {
        when(productTypeRepository.getProductTypeById(1)).thenReturn(null);

        Exception exception = assertThrows(ProductTypeServiceException.class, () -> {
            productTypeService.getProductTypeById(1);
        });

        assertEquals("Product type not found", exception.getMessage());
        verify(productTypeRepository, times(1)).getProductTypeById(1);
    }

}
