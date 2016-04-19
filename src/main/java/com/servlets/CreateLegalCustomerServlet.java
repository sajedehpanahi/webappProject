package com.servlets;

import com.exceptions.FieldIsRequiredException;
import com.logicLayer.CustomerValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CreateLegalCustomerServlet")
public class CreateLegalCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String companyName = request.getParameter("companyName");
        String dateOfRegistration = request.getParameter("dateOfRegistration");
        String economicCode = request.getParameter("economicCode");
        String outputHTML="";

        OutPutGenerator outPutGenerator = new OutPutGenerator();
        try {
            CustomerValidator customerValidator = new CustomerValidator();
            String customerNumber = customerValidator.validateAndCreate(companyName, dateOfRegistration, economicCode);
            outputHTML =outPutGenerator.generate(companyName, dateOfRegistration, economicCode,customerNumber);
        }catch (FieldIsRequiredException e){
            outputHTML = outPutGenerator.generate(e.getMessage());
        }
        //TODO add another catch statement for repetitive economicCode

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);

    }

}
