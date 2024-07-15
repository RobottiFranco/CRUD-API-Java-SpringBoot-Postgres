package com.posteleria.crudApp.Service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.posteleria.crudApp.Service.DataBaseConnection;

@Component
public class DataBaseConnectionImpl implements DataBaseConnection{

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    private static DataBaseConnection instance;
    private Connection connection;

    private DataBaseConnectionImpl() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
    }

    public DataBaseConnection getInstance() throws SQLException {
        if (instance == null) {
            synchronized (DataBaseConnection.class) {
                if (instance == null) {
                    instance = new DataBaseConnectionImpl();
                }
            }
        } else if (instance.getConnection().isClosed()) {
            instance = new DataBaseConnectionImpl();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}