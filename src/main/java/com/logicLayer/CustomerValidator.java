package com.logicLayer;

import com.exceptions.FieldIsRequiredException;

public class CustomerValidator {

    public String validateAndCreate(String firstName,String lastName, String fatherName, String dateOfBirth, String nationalCode)
            throws FieldIsRequiredException {

        RealCustomerValidator realCustomerValidator = new RealCustomerValidator();
        realCustomerValidator.validate(firstName.trim(),lastName.trim(),fatherName.trim(),dateOfBirth.trim(),nationalCode.trim());

        //TODO create customer and insert to data base using customerCRUD.Create method

        //customerNumber comes from customerCrud method
        String customerNumber="customerNumber";

        return customerNumber;

    }

    public String validateAndCreate(String companyName, String dateOfRegistration, String economicCode) throws FieldIsRequiredException {

        LegalCustomerValidator legalCustomerValidator = new LegalCustomerValidator();
        legalCustomerValidator.validate(companyName.trim(),dateOfRegistration.trim(),economicCode.trim());


        //TODO  insert customer to data base using customerCRUD.Create method

        //customerNumber comes from customerCrud method
        String customerNumber="customerNumber";

        return customerNumber;

    }
}
