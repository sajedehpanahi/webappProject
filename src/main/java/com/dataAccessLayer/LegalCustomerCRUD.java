package com.dataAccessLayer;

import com.util.SingletonConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LegalCustomerCRUD {
    public static void create(LegalCustomer legalCustomer)
            throws SQLException {
        PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("INSERT INTO legal_customer VALUES ( ?, ?, ?, ?);");
        preparedStatement.setInt(1, Integer.parseInt(legalCustomer.getEconomicCode()));
        preparedStatement.setString(2, legalCustomer.getCompanyName());
        preparedStatement.setDate(3, Date.valueOf(legalCustomer.getDateOfRegistration()));
        preparedStatement.setString(3, legalCustomer.getCompanyName());
        preparedStatement.setString(4, legalCustomer.getCustomerNumber());
        preparedStatement.executeUpdate();
    }
}
