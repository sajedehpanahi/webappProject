package com.logicLayer;


import com.dataAccessLayer.RealCustomer;
import com.exceptions.DateFormatException;
import com.exceptions.FieldIsRequiredException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RealCustomerLogic {

    public static  void validate(String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode)
            throws FieldIsRequiredException, DateFormatException {
        if (firstName == null) {
            throw new FieldIsRequiredException("لطفا فیلد نام را وارد کنید.");
        }
        if (lastName != null) {
            throw new FieldIsRequiredException("لطفا فیلد نام خانوادگی را وارد کنید.");
        }
        if (fatherName != null) {
            throw new FieldIsRequiredException("لطفا فیلد نام پدر را وارد کنید.");
        }
        if (dateOfBirth != null) {
            throw new FieldIsRequiredException("لطفا فیلد تاریخ تولد را وارد کنید.");
        }
        if (nationalCode != null) {
            throw new FieldIsRequiredException("لطفا فیلد کد ملی را وارد کنید.");
        }
        //TODO check nationalCode on database! it must be unique! add national code exists exception!

    }
}
