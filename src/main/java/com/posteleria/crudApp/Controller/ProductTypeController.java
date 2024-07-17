package com.posteleria.crudApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.posteleria.crudApp.Model.ProductType;
import com.posteleria.crudApp.Service.ProductTypeService;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping("/addProductType")
    public ResponseEntity<Void> addProductType(@RequestBody ProductType productType) {
        productTypeService.addProductType(productType);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/updateProductType")
    public ResponseEntity<Void> updateProductType(@RequestBody ProductType productType) {
        productTypeService.updateProductType(productType);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteProductType")
    public ResponseEntity<Void> deleteProductType(@RequestParam int productTypeId) {
        productTypeService.deleteProductType(productTypeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getProductTypes")
    public ResponseEntity<List<ProductType>> getAllProductTypes() {
        List<ProductType> productTypes = productTypeService.getAllProductTypes();
        return ResponseEntity.ok(productTypes);
    }
}
