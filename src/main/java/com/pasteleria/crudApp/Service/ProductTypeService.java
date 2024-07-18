package com.pasteleria.crudApp.Service;

import java.util.List;

import com.pasteleria.crudApp.Model.ProductType;

public interface ProductTypeService {

    void addProductType(ProductType productType);

    void updateProductType(ProductType productType);

    void deleteProductType(int productTypeId);

    List<ProductType> getAllProductTypes();

    ProductType getProductTypeById(int productTypeId);
}
