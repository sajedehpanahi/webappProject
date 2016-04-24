package com.dataAccessLayer;

import com.exceptions.AssignCustomerNumberException;
import com.mysql.jdbc.*;
import com.util.SingletonConnection;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CustomerCRUD {

    public static String create(RealCustomer realCustomer)
            throws SQLException, AssignCustomerNumberException {

        String customerNumber = "";
        try {
            PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("INSERT INTO customer () VALUES ();",Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                customerNumber = String.valueOf(resultSet.getInt(1));
                /*preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("INSERT INTO customer (customer_number) VALUES (?)");
                preparedStatement.setString(1,customerNumber);
                preparedStatement.executeUpdate();*/
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (customerNumber != "") {
            realCustomer.setCustomerNumber(customerNumber);
        } else {
            throw new AssignCustomerNumberException("خطا در تخصیص شماره مشتری! لطفا مجددا تلاش نمایید.");
        }

        RealCustomerCRUD.create(realCustomer);

        return customerNumber;
    }

    public static String create(LegalCustomer legalCustomer)
            throws AssignCustomerNumberException, SQLException {

        int customerNumber = 0;
        try {
            PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("INSERT INTO customer (customer_type) VALUES ('legal')");
            preparedStatement.executeUpdate();

            preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("SET @last_id = LAST_INSERT_ID();");
            preparedStatement.executeQuery();

            preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("SELECT @last_id");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                customerNumber = resultSet.getInt(1);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (customerNumber != 0) {
            legalCustomer.setCustomerNumber(String.valueOf(customerNumber));
        } else {
            throw new AssignCustomerNumberException("خطا در تخصیص شماره مشتری! لطفا مجددا تلاش نمایید.");
        }

        LegalCustomerCRUD.create(legalCustomer);

        return legalCustomer.getCustomerNumber();
    }
}
