package com.posteleria.crudApp.Repository;


import java.util.List;

import com.posteleria.crudApp.Model.ProductType;

public interface ProductTypeRepository {

    void addProductType(ProductType productType);

    void updateProductType(ProductType productType);

    void deleteProductType(int productTypeId);

    List<ProductType> getAllProductTypes();

}
