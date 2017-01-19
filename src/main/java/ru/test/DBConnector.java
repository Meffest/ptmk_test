package ru.test;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Соединение с базой данных
 */
public class DBConnector {
    private Connection connection;

    public DBConnector() throws SQLException {
        DriverManager.registerDriver(new FabricMySQLDriver());
    }

    public Connection getConnection(String url, String username, String password) throws SQLException {
        if (connection != null) {
            return connection;
        }
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
