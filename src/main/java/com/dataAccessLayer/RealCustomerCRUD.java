package com.dataAccessLayer;

import com.util.SingletonConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RealCustomerCRUD {

    public static void create(RealCustomer realCustomer)
            throws SQLException {
        PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection()
                .prepareStatement(
                        "INSERT INTO real_customer(national_code , first_name , last_name , father_name , date_of_birth , customer_number )" +
                        " VALUES ( ?, ?, ?, ?, ?, ?);");
        preparedStatement.setInt(1, Integer.parseInt(realCustomer.getNationalCode()));
        preparedStatement.setString(2, realCustomer.getFirstName());
        preparedStatement.setString(3, realCustomer.getLastName());
        preparedStatement.setString(4, realCustomer.getFatherName());
        preparedStatement.setDate(5, Date.valueOf(realCustomer.getDateOfBirth()));
        preparedStatement.setString(6, realCustomer.getCustomerNumber());
        preparedStatement.executeUpdate();
    }
}
