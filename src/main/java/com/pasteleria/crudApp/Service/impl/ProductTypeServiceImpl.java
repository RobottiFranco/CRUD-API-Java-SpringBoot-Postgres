package com.pasteleria.crudApp.Service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasteleria.crudApp.Exception.ProductTypeServiceException;
import com.pasteleria.crudApp.Model.ProductType;
import com.pasteleria.crudApp.Repository.ProductTypeRepository;
import com.pasteleria.crudApp.Service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public void addProductType(ProductType productType) {
        try {
            productTypeRepository.addProductType(productType);
        } catch (Exception e) {
            throw new ProductTypeServiceException("Error adding product type: " + e.getMessage());
        }
    }

    @Override
    public void updateProductType(ProductType productType) {
        try {
            if (productTypeRepository.getProductTypeById(productType.getProductTypeId()) == null) {
                throw new ProductTypeServiceException("Product type not found");
            }
            productTypeRepository.updateProductType(productType);
        } catch (Exception e) {
            throw new ProductTypeServiceException("Error updating product type: " + e.getMessage());
        }
    }

    @Override
    public void deleteProductType(int productTypeId) {
        try {
            if (productTypeRepository.getProductTypeById(productTypeId) == null) {
                throw new ProductTypeServiceException("Product type not found");
            }
            productTypeRepository.deleteProductType(productTypeId);
        } catch (Exception e) {
            throw new ProductTypeServiceException("Error deleting product type: " + e.getMessage());
        }
    }

    @Override
    public List<ProductType> getAllProductTypes() {
        try {
            return productTypeRepository.getAllProductTypes();
        } catch (Exception e) {
            throw new ProductTypeServiceException("Error retrieving product types: " + e.getMessage());
        }
    }

    @Override
    public ProductType getProductTypeById(int productTypeId) {
        try {
            return productTypeRepository.getProductTypeById(productTypeId);
        } catch (Exception e) {
            throw new ProductTypeServiceException("Error retrieving product type: " + e.getMessage());
        }
    }
}