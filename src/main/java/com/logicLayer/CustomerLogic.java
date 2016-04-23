package com.logicLayer;

import com.dataAccessLayer.CustomerCRUD;
import com.dataAccessLayer.LegalCustomer;
import com.dataAccessLayer.RealCustomer;
import com.exceptions.AssignCustomerNumberException;
import com.exceptions.DateFormatException;
import com.exceptions.FieldIsRequiredException;

import java.sql.SQLException;

public class CustomerLogic {

    public static RealCustomer CreateCustomer(String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode)
            throws FieldIsRequiredException, DateFormatException, SQLException, AssignCustomerNumberException {


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
            throws FieldIsRequiredException, SQLException, AssignCustomerNumberException {

        LegalCustomerLogic.validate(companyName.trim(),dateOfRegistration.trim(),economicCode.trim());

        LegalCustomer legalCustomer = new LegalCustomer();
        legalCustomer.setCompanyName(companyName);
        legalCustomer.setDateOfRegistration(dateOfRegistration);
        legalCustomer.setEconomicCode(economicCode);
        legalCustomer.setCustomerNumber(CustomerCRUD.create(legalCustomer));

        return  legalCustomer;
    }
}
