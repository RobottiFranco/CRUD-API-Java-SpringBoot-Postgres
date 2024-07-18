package com.posteleria.crudApp.Service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.posteleria.crudApp.Model.ProductType;
import com.posteleria.crudApp.Repository.ProductTypeRepository;
import com.posteleria.crudApp.Service.ProductTypeService;

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