package com.posteleria.crudApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.posteleria.crudApp.Model.ProductType;
import com.posteleria.crudApp.Service.ProductTypeService;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping("/addProductType")
    public void addProductType(ProductType productType) {
        productTypeService.addProductType(productType);
    }

    @PutMapping("/updateProductType/{productTypeId}")
    public void updateProductType(@PathVariable int productTypeId, @RequestBody ProductType productType) {
        productTypeService.updateProductType(productType);
    }

    @DeleteMapping("/deleteProductType/{productTypeId}")
    public void deleteProductType(int productTypeId) {
        productTypeService.deleteProductType(productTypeId);
    }

    @GetMapping("/getProductTypes")
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }
}
