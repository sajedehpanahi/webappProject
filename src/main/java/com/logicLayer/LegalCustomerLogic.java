package com.logicLayer;

import com.dataAccessLayer.LegalCustomerCRUD;
import com.exceptions.DataBaseConnectionException;
import com.exceptions.FieldIsRequiredException;

import java.sql.SQLException;

public class LegalCustomerLogic {

    public static void validate(String companyName, String dateOfRegistration, String economicCode)
            throws FieldIsRequiredException {

        if(companyName == null) {
            throw new FieldIsRequiredException("لطفا فیلد نام شرکت را وارد کنید.");
        }
        if(dateOfRegistration == null) {
            throw new FieldIsRequiredException("لطفا فیلد تاریخ ثبت را وارد کنید.");
        }
        if(economicCode == null) {
            throw new FieldIsRequiredException("لطفا فیلد کد اقتصادی را وارد کنید.");
        }

        //TODO check economicCode on database! it must be unique! add economic code exists exception!
    }
    public static void retrieveCustomer(){
        //TODO validate new inputs
    }
    public static void deleteById(int id)
            throws SQLException, DataBaseConnectionException {
        LegalCustomerCRUD.deleteById(id);
    }
}
