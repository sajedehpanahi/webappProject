package com.dataAccessLayer;

import com.dataAccessLayer.Beans.LegalCustomer;
import com.dataAccessLayer.Beans.RealCustomer;
import com.exceptions.AssignCustomerNumberException;
import com.exceptions.DataBaseConnectionException;
import com.exceptions.DuplicateInformationException;
import com.util.SingletonConnection;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerCRUD {

    public static String create(RealCustomer realCustomer)
            throws AssignCustomerNumberException, DuplicateInformationException {
        realCustomer.setCustomerNumber(generateCustomerNumber());
        try {
            RealCustomerCRUD.create(realCustomer);
        } catch (DataBaseConnectionException e) {
            deleteByCustomerNumber(realCustomer.getCustomerNumber());
            throw new DuplicateInformationException(e.getLocalizedMessage()+"اطلاعات وارد شده تکراری است!");
        }
        return realCustomer.getCustomerNumber();
    }

    public static String create(LegalCustomer legalCustomer)
            throws AssignCustomerNumberException, DuplicateInformationException {

        legalCustomer.setCustomerNumber(generateCustomerNumber());
        try {
            LegalCustomerCRUD.create(legalCustomer);
        }catch (DataBaseConnectionException e) {
            deleteByCustomerNumber(legalCustomer.getCustomerNumber());
            throw new DuplicateInformationException(e.getLocalizedMessage()+"اطلاعات وارد شده تکراری است!");
        }
        return legalCustomer.getCustomerNumber();
    }

    private static String generateCustomerNumber()
            throws AssignCustomerNumberException {
        String customerNumber = "";
        try {
            PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("INSERT INTO customer () VALUES ()", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                customerNumber = String.valueOf(resultSet.getInt(1));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (customerNumber == "") {
            throw new AssignCustomerNumberException("خطا در تخصیص شماره مشتری! لطفا مجددا تلاش نمایید.");
        }
        return customerNumber;
    }

    private static void deleteCustomerByCustomerNumber(String customerNumber){
        try {
            PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("DELETE From customer WHERE id=?;");
            preparedStatement.setInt(1, Integer.parseInt(customerNumber));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteByCustomerNumber(String customerNumber){
        deleteCustomerByCustomerNumber(customerNumber);
    }

    public  static ArrayList<LegalCustomer> retrieve(String customerNumber, String companyName, String dateOfRegistration, String economicCode)
            throws SQLException {
        return  LegalCustomerCRUD.retrieve(customerNumber, companyName, dateOfRegistration, economicCode);

    }

    public static ArrayList<RealCustomer> retrieve(String customerNumber, String nationalCode, String firstName, String lastName, String fatherName, String dateOfBirth)
            throws SQLException {
        return RealCustomerCRUD.retrieve(customerNumber, nationalCode, firstName,lastName,fatherName,dateOfBirth);
    }


}
