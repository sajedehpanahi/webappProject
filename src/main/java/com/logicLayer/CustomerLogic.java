package com.logicLayer;

import com.dataAccessLayer.Beans.LegalCustomer;
import com.dataAccessLayer.Beans.RealCustomer;
import com.dataAccessLayer.CustomerCRUD;

import com.dataAccessLayer.LegalCustomerCRUD;

import com.exceptions.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerLogic {

    public static RealCustomer CreateCustomer(String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode)
            throws FieldIsRequiredException, DateFormatException, SQLException, AssignCustomerNumberException, DuplicateInformationException {
        RealCustomerLogic.validate(firstName.trim(),lastName.trim(),fatherName.trim(),dateOfBirth.trim(),nationalCode.trim());
        RealCustomer realCustomer = new RealCustomer();
        realCustomer.setFirstName(firstName);
        realCustomer.setLastName(lastName);
        realCustomer.setFatherName(fatherName);
        realCustomer.setDateOfBirth(dateOfBirth);
        realCustomer.setNationalCode(nationalCode);
        realCustomer.setCustomerNumber(CustomerCRUD.create(realCustomer));
        return  realCustomer;
    }

    public static LegalCustomer CreateCustomer(String companyName, String dateOfRegistration, String economicCode)
            throws FieldIsRequiredException, SQLException, AssignCustomerNumberException, DuplicateInformationException {

        LegalCustomerLogic.validate(companyName.trim(),dateOfRegistration.trim(),economicCode.trim());

        LegalCustomer legalCustomer = new LegalCustomer();
        legalCustomer.setCompanyName(companyName);
        legalCustomer.setDateOfRegistration(dateOfRegistration);
        legalCustomer.setEconomicCode(economicCode);
        legalCustomer.setCustomerNumber(CustomerCRUD.create(legalCustomer));

        return  legalCustomer;
    }

    public static ArrayList<RealCustomer> retrieveCustomer(String customerNumber, String nationalCode, String firstName, String lastName, String fatherName, String dateOfBirth)
            throws SQLException {
        RealCustomerLogic.retrieveCustomer();
        return CustomerCRUD.retrieve(customerNumber, nationalCode, firstName,lastName,fatherName,dateOfBirth);
    }

    public static ArrayList<LegalCustomer> retrieveCustomer(String customerNumber, String companyName, String dateOfRegistration, String economicCode)
            throws SQLException {

        LegalCustomerLogic.retrieveCustomer();
        return CustomerCRUD.retrieve(customerNumber, companyName, dateOfRegistration, economicCode);
    }

    public static LegalCustomer retrieveCustomerById(int id)
            throws SQLException {
        return LegalCustomerCRUD.retrieveCustomerById(id);
    }

    public static void updateCustomer(int id, String companyName, String dateOfRegistration, String economicCode)
            throws SQLException, DataBaseConnectionException {
        LegalCustomerCRUD.update(id,companyName, dateOfRegistration, economicCode);
    }
}
