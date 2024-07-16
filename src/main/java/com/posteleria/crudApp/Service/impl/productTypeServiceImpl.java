package com.posteleria.crudApp.Service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posteleria.crudApp.Model.ProductType;
import com.posteleria.crudApp.Service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private DataSource dataSource;

    @Override
    public void addProductType(ProductType productType) {
        String query = "INSERT INTO ProductType(name) VALUES (?)";

        try (Connection con = dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, productType.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProductType(ProductType productType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProductType'");
    }

    @Override
    public void deleteProductType(int productTypeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProductType'");
    }

    @Override
    public List<ProductType> getAllProductTypes() {
        List<ProductType> result = new LinkedList<>();
        try (Connection con = dataSource.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ProductType");

            while (rs.next()) {
                ProductType productType = new ProductType();
                productType.setProductTypeId(rs.getInt("ProductTypeID"));
                productType.setName(rs.getString("name"));
                result.add(productType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}