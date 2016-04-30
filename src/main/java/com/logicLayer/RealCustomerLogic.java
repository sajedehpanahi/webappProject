package com.logicLayer;


import com.dataAccessLayer.Beans.RealCustomer;
import com.dataAccessLayer.CustomerCRUD;
import com.dataAccessLayer.RealCustomerCRUD;
import com.exceptions.AssignCustomerNumberException;
import com.exceptions.DateFormatException;
import com.exceptions.FieldIsRequiredException;

import java.sql.SQLException;

public class RealCustomerLogic {

    public static  void validate(String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode)
            throws FieldIsRequiredException, DateFormatException {
        if (firstName.isEmpty()) {
            throw new FieldIsRequiredException("لطفا فیلد نام را وارد کنید.");
        }
        if (lastName.isEmpty()) {
            throw new FieldIsRequiredException("لطفا فیلد نام خانوادگی را وارد کنید.");
        }
        if (fatherName.isEmpty()) {
            throw new FieldIsRequiredException("لطفا فیلد نام پدر را وارد کنید.");
        }
        if (dateOfBirth.isEmpty()) {
            throw new FieldIsRequiredException("لطفا فیلد تاریخ تولد را وارد کنید.");
        }
        if (nationalCode.isEmpty()) {
            throw new FieldIsRequiredException("لطفا فیلد کد ملی را وارد کنید.");
        }
        //TODO check nationalCode on database! it must be unique! add national code exists exception!

    }

    public static void retrieveCustomer(){
        //TODO validate new inputs
    }

    public static void deleteById(int id)
            throws SQLException {
        RealCustomer realCustomer = RealCustomerCRUD.retrieveCustomerById(id);
        CustomerCRUD.deleteByCustomerNumber(realCustomer.getCustomerNumber());
    }

    public static RealCustomer retrieveCustomerById(int id)
            throws SQLException {
       return  RealCustomerCRUD.retrieveCustomerById(id);
    }
}
