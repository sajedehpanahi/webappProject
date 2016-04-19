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

@WebServlet(name = "CreateRealCustomerServlet")
public class CreateRealCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String fatherName = request.getParameter("fatherName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String nationalCode = request.getParameter("nationalCode");
        String outputHTML="";

        OutPutGenerator outPutGenerator = new OutPutGenerator();
        try{
            CustomerValidator customerValidator = new CustomerValidator();
            String customerNumber = customerValidator.validateAndCreate(firstName,lastName,fatherName,dateOfBirth,nationalCode);
            outputHTML = outPutGenerator.generate(firstName,lastName,fatherName,dateOfBirth,nationalCode,customerNumber);
        } catch (FieldIsRequiredException e) {
            outputHTML = outPutGenerator.generate(e.getMessage());
        }
        //TODO add another catch statement for repetitive nationalCode


        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);

    }
}
