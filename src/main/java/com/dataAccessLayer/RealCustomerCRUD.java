package com.dataAccessLayer;

import com.dataAccessLayer.Beans.RealCustomer;
import com.exceptions.DataBaseConnectionException;
import com.util.SingletonConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
        //generatePreparedStatement("custoemrnumber","1425630","aaa","","سسس");
        try (PreparedStatement preparedStatement = generatePreparedStatement(customerNumber,nationalCode,firstName,lastName,fatherName);) {
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

    private static PreparedStatement generatePreparedStatement(String customerNumber, String nationalCode, String firstName, String lastName, String fatherName) {
        PreparedStatement preparedStatement = null;
        StringBuilder sqlCommand = new StringBuilder("SELECT * From real_customer WHERE ");
        int counter = 1;
        List<String> parametrs = new ArrayList<String>();
        if(customerNumber != "" && customerNumber != null) {
            sqlCommand.append(" customer_number=? AND");
            parametrs.add(customerNumber);
        }
        if(nationalCode != "") {
            sqlCommand.append(" national_code=? AND");
            parametrs.add(nationalCode);
        }
        if(firstName != "") {
            sqlCommand.append(" first_name=? AND");
            parametrs.add(firstName);
        }
        if(lastName != "") {
            sqlCommand.append(" last_name=? AND");
            parametrs.add(lastName);
        }
        if(fatherName != "") {
            sqlCommand.append(" father_name=? AND");
            parametrs.add(fatherName);
        }
        sqlCommand.append(" true");

        try {
            preparedStatement = SingletonConnection.getSingletonConnection().prepareStatement(sqlCommand.toString());
            for (String parametr : parametrs){

                preparedStatement.setString(counter++,parametr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;


            //TODO coplelete search


    }
}
