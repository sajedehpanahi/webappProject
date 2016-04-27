package com.dataAccessLayer;

import com.dataAccessLayer.Beans.LegalCustomer;
import com.exceptions.DataBaseConnectionException;
import com.util.SingletonConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LegalCustomerCRUD {
    public static void create(LegalCustomer legalCustomer)
            throws DataBaseConnectionException {
        try(PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection()
                .prepareStatement("INSERT INTO legal_customer (customer_number, company_name, economic_code, date_of_registration) VALUES ( ?, ?, ?, ?);");) {
            preparedStatement.setInt(1, Integer.parseInt(legalCustomer.getCustomerNumber()));
            preparedStatement.setString(2, legalCustomer.getCompanyName());
            preparedStatement.setString(3, legalCustomer.getEconomicCode());
            preparedStatement.setDate(4, Date.valueOf(legalCustomer.getDateOfRegistration()));
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new DataBaseConnectionException(e.getMessage() + "خطا در ایجاد اتصال به پایگاه داده!");
        }
    }

    public static ArrayList<LegalCustomer> retrieve(String customerNumber, String companyName, String dateOfRegistration, String economicCode)
            throws SQLException {
        PreparedStatement preparedStatement = generatePreparedStatement(customerNumber, companyName, dateOfRegistration, economicCode);
        ResultSet results = preparedStatement.executeQuery();
        ArrayList<LegalCustomer> legalCustomers = new ArrayList<LegalCustomer>();

        while (results.next()) {
            LegalCustomer legalCustomer = new LegalCustomer();
            legalCustomer.setId(results.getInt("id"));
            legalCustomer.setCustomerNumber(String.valueOf(results.getInt("customer_number")));
            legalCustomer.setCompanyName(results.getString("company_name"));
            legalCustomer.setEconomicCode(results.getString("economic_code"));
            legalCustomer.setDateOfRegistration(String.valueOf(results.getDate("date_of_registration").toLocalDate()));
            legalCustomers.add(legalCustomer);
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        return legalCustomers;
    }

    public static LegalCustomer retrieveCustomerById(int id)
            throws SQLException {
        PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("SELECT * From legal_customer WHERE id=?;");
        preparedStatement.setInt(1, id);
        ResultSet results = preparedStatement.executeQuery();
        LegalCustomer legalCustomer = new LegalCustomer();
        if (results.next()) {
            legalCustomer.setId(results.getInt("id"));
            legalCustomer.setCustomerNumber(String.valueOf(results.getInt("customer_number")));
            legalCustomer.setCompanyName(results.getString("company_name"));
            legalCustomer.setEconomicCode(results.getString("economic_code"));
            legalCustomer.setDateOfRegistration(String.valueOf(results.getDate("date_of_registration").toLocalDate()));
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        return legalCustomer;
    }

    public static void update(int id, String companyName, String dateOfRegistration, String economicCode)
            throws DataBaseConnectionException {
        try(PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection()
                .prepareStatement("UPDATE legal_customer SET company_name = ? , economic_code =  ? ,  date_of_registration = ?  WHERE id=?");) {
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, economicCode);
            preparedStatement.setDate(3, Date.valueOf(dateOfRegistration));
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new DataBaseConnectionException(e.getMessage() + "خطا در به روز رسانی اطلاعات پایگاه داده!");
        }
    }

    public static void deleteById(int id)
            throws DataBaseConnectionException {
        try(PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection()
                .prepareStatement("DELETE FROM legal_customer  WHERE id=?");) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new DataBaseConnectionException(e.getMessage() + "خطا در حذف اطلاعات پایگاه داده!");
        }
    }

    private static PreparedStatement generatePreparedStatement(String customerNumber, String companyName, String dateOfRegistration, String economicCode)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        if (customerNumber != "") {
            preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("SELECT * From legal_customer WHERE customer_number=?;");
            preparedStatement.setInt(1, Integer.parseInt(customerNumber));
        } else if (economicCode != "") {
            preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("SELECT * From legal_customer WHERE economic_code=?;");
            preparedStatement.setString(1, economicCode);
        } else if (companyName != "" && dateOfRegistration != "") {
            preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("SELECT * From legal_customer WHERE company_name=? and date_of_registration=?;");
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, dateOfRegistration);
        } else if (companyName != "") {
            preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("SELECT * From legal_customer WHERE company_name=?;");
            preparedStatement.setString(1, companyName);
        } else if (dateOfRegistration != "") {
            preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("SELECT * From legal_customer WHERE date_of_registration=?;");
            preparedStatement.setString(1, dateOfRegistration);
        } else {
            preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("SELECT * From legal_customer;");
        }
        return preparedStatement;
    }
}
