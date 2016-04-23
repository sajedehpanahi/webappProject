package com.util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static java.sql.Connection connection = null;

    private SingletonConnection(){}
    static {
        try {
            Class.forName(JDBC_DRIVER);
            String DB_URL = "jdbc:mysql://localhost:3306/DATA_BANK?useSSL=false";
            String USER = "root";
            String PASS = "root";
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static java.sql.Connection getSingletonConnection(){
        return connection;
    }
}
