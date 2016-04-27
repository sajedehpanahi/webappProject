package com.dataAccessLayer;

import com.dataAccessLayer.Beans.RealCustomer;
import com.exceptions.DataBaseConnectionException;
import com.util.SingletonConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RealCustomerCRUD {

    static void create(RealCustomer realCustomer)
            throws DataBaseConnectionException {
        try (PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection()
                .prepareStatement(
                        "INSERT INTO real_customer(customer_number, national_code, first_name, last_name, father_name, date_of_birth)" +
                                " VALUES ( ?, ?, ?, ?, ?, ?);");) {
            preparedStatement.setString(1, realCustomer.getCustomerNumber());
            preparedStatement.setInt(2, Integer.parseInt(realCustomer.getNationalCode()));
            preparedStatement.setString(3, realCustomer.getFirstName());
            preparedStatement.setString(4, realCustomer.getLastName());
            preparedStatement.setString(5, realCustomer.getFatherName());
            preparedStatement.setDate(6, Date.valueOf(realCustomer.getDateOfBirth()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataBaseConnectionException(e.getMessage() + "خطا در ایجاد اتصال به پایگاه داده!");
        }
    }

    static ArrayList<RealCustomer> retrieve(String customerNumber, String nationalCode, String firstName, String lastName, String fatherName, String dateOfBirth) {
        ArrayList<RealCustomer> realCustomers = new ArrayList<RealCustomer>();
        try (PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection()
                .prepareStatement("SELECT * From legal_customer WHERE customer_number=?;");) {
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                RealCustomer realCustomer = new RealCustomer();
                realCustomer.setId(results.getInt("id"));
                realCustomer.setCustomerNumber(String.valueOf(results.getInt("customer_number")));
                realCustomer.setNationalCode(results.getString("national_code"));
                realCustomer.setFirstName(results.getString("first_name"));
                realCustomer.setLastName(results.getString("last_name"));
                realCustomer.setFatherName(results.getString("father_name"));
                realCustomer.setDateOfBirth(String.valueOf(results.getDate("date_of_birth").toLocalDate()));
                realCustomers.add(realCustomer);
            }
        } catch (SQLException e) {
        }
        return realCustomers;
    }

    public static RealCustomer retrieveCustomerById(int id)
            throws SQLException {
        PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement("SELECT * From real_customer WHERE id=?;");
        preparedStatement.setInt(1, id);
        ResultSet results = preparedStatement.executeQuery();
        RealCustomer realCustomer = new RealCustomer();
        if (results.next()) {
            realCustomer.setId(results.getInt("id"));
            realCustomer.setCustomerNumber(String.valueOf(results.getInt("customer_number")));
            realCustomer.setFirstName(results.getString("first_name"));
            realCustomer.setLastName(results.getString("last_name"));
            realCustomer.setFatherName(results.getString("father_name"));
            realCustomer.setNationalCode(results.getString("national_code"));
            realCustomer.setDateOfBirth(String.valueOf(results.getDate("date_of_birth").toLocalDate()));
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        return realCustomer;
    }

    public static void update(int id, String nationalCode, String firstName, String lastName, String fatherName, String dateOfBirth)
            throws DataBaseConnectionException {
        try (PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection()
                .prepareStatement("UPDATE real_customer SET first_name = ? , lastName =  ? ,  fatherName = ?  ,  nationalCode = ?  ,  dateOfBirth = ?  WHERE id=?");) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, fatherName);
            preparedStatement.setString(4, nationalCode);
            preparedStatement.setDate(5, Date.valueOf(dateOfBirth));
            preparedStatement.setInt(6, id);
        } catch (SQLException e) {
            throw new DataBaseConnectionException(e.getMessage() + "خطا در به روز رسانی اطلاعات پایگاه داده!");
        }
    }

    public static void deleteById(int id)
            throws DataBaseConnectionException {
        try (PreparedStatement preparedStatement = SingletonConnection.getSingletonConnection()
                .prepareStatement("DELETE FROM real_customer  WHERE id=?");) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataBaseConnectionException(e.getMessage() + "خطا در حذف اطلاعات پایگاه داده!");
        }
    }

    private static PreparedStatement generatePreparedStatement(String customerNumber, String nationalCode, String firstName, String lastName, String fatherName, String dateOfBirth) {
        PreparedStatement preparedStatement = null;
        StringBuilder sqlCommand = new StringBuilder("SELECT * From real_customer ");
        int counter = 0;
        return preparedStatement;


            //TODO coplelete search


    }
}
