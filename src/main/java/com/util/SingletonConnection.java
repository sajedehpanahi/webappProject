package com.util;

import com.exceptions.DataBaseConnectionException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonConnection {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static java.sql.Connection connection = null;

    private SingletonConnection() {
    }

    static {
        try {
            Class.forName(JDBC_DRIVER);
            String DB_URL = "jdbc:mysql://localhost:3306/mybank?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
            String USER = "root";
            String PASS = "root";
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("خطا در ایجاد اتصال به پایگاه داده");
        }
    }

    public static java.sql.Connection getSingletonConnection() {
        return connection;

    }
}
