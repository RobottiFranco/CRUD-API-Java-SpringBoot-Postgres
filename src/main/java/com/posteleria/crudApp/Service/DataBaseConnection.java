package com.posteleria.crudApp.Service;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseConnection {

    Connection getConnection();

    void closeConnection() throws SQLException;

    DataBaseConnection getInstance() throws SQLException;
}