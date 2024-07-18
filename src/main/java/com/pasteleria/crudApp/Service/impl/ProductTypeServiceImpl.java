package com.pasteleria.crudApp.Service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pasteleria.crudApp.Model.ProductType;
import com.pasteleria.crudApp.Repository.ProductTypeRepository;
import com.pasteleria.crudApp.Service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public void addProductType(ProductType productType) {
        productTypeRepository.addProductType(productType);
    }

    @Override
    public void updateProductType(ProductType productType) {
        productTypeRepository.updateProductType(productType);
    }

    @Override
    public void deleteProductType(int productTypeId) {
        productTypeRepository.deleteProductType(productTypeId);
    }

    @Override
    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.getAllProductTypes();
    }
}