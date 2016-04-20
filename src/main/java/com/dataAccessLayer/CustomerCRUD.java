package com.dataAccessLayer;

import java.sql.*;

public class CustomerCRUD {

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/DATA_BANK";
    private final String USER = "root";
    private final String PASS = "root";

    public String create(String firstName,String lastName, String fatherName, String dateOfBirth, String nationalCode){

        Connection connection = null;
        Statement statement = null;
        int customerNumber = 0;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

            String query = "INSERT INTO customer (customer_type) VALUES ('real')";
            statement.executeUpdate(query);

            query = "SET @last_id = LAST_INSERT_ID();";
            statement.executeQuery(query);

            query = "SELECT @last_id";
            ResultSet resultSet=statement.executeQuery(query);

            if(resultSet.next()) {
                customerNumber = resultSet.getInt(1);
            }
            resultSet.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(customerNumber==0);
            //TODO Throw exception

        //TODO add customer tp real customer using real customer CRUD

        //return customerNumber

        return "customerNumber";
    }

    public String create(String companyName, String dateOfRegistration, String economicCode){

        //TODO add customer to customer and get customerNumber

        //TODO add customer tp legal customer using legal customer CRUD

        //return customerNumber

        return "customerNumber";
    }
}
