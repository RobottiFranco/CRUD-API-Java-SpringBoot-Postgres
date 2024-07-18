package com.posteleria.crudApp.Repository.impl;

import org.springframework.stereotype.Repository;
import com.posteleria.crudApp.Model.ProductType;
import com.posteleria.crudApp.Repository.ProductTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ProductTypeRepositoryImpl implements ProductTypeRepository {

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
        String query = "UPDATE ProductType SET name = ? WHERE ProductTypeID = ?";

        try (Connection con = dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, productType.getName());
            pstmt.setInt(2, productType.getProductTypeId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProductType(int productTypeId) {
        String query = "DELETE FROM ProductType WHERE ProductTypeID = ?";
        try (Connection con = dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, productTypeId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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