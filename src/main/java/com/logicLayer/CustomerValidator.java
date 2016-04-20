package com.logicLayer;

import com.dataAccessLayer.CustomerCRUD;
import com.exceptions.FieldIsRequiredException;

public class CustomerValidator {

    public String validateAndCreate(String firstName,String lastName, String fatherName, String dateOfBirth, String nationalCode)
            throws FieldIsRequiredException {

        RealCustomerValidator realCustomerValidator = new RealCustomerValidator();
        realCustomerValidator.validate(firstName.trim(),lastName.trim(),fatherName.trim(),dateOfBirth.trim(),nationalCode.trim());

        //TODO need to throw some exceptions
        CustomerCRUD customerCRUD = new CustomerCRUD();
        return  customerCRUD.create(firstName,lastName,fatherName,dateOfBirth,nationalCode);
    }

    public String validateAndCreate(String companyName, String dateOfRegistration, String economicCode)
            throws FieldIsRequiredException {

        LegalCustomerValidator legalCustomerValidator = new LegalCustomerValidator();
        legalCustomerValidator.validate(companyName.trim(),dateOfRegistration.trim(),economicCode.trim());

        //TODO need to throw some exceptions
        CustomerCRUD customerCRUD = new CustomerCRUD();
        return  customerCRUD.create(companyName,dateOfRegistration,economicCode);
    }
}
