package com.posteleria.crudApp.Service;

import java.util.List;

import com.posteleria.crudApp.Model.ProductType;

public interface ProductTypeService {

    void addProductType(ProductType productType);

    void updateProductType(ProductType productType);

    void deleteProductType(int productTypeId);

    List<ProductType> getAllProductTypes();

}
