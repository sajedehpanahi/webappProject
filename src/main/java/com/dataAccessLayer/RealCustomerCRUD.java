package com.dataAccessLayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RealCustomerCRUD {

    public void create(String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode, String customerNumber, Connection connection)
            throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat(dateOfBirth);
        //Date date=dateFormat
        Statement statement = connection.createStatement();
        String query = "INSERT INTO legal_customer VALUES ("+ Integer.parseInt(nationalCode.trim())+",'"+firstName+"','"+lastName+"','"+fatherName+"','"+ "'123457','dotin','2014-01-01',@last_id)";
        statement.executeUpdate(query);

    }
}
