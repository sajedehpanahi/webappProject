package com.servlets;

import com.dataAccessLayer.LegalCustomer;
import com.exceptions.AssignCustomerNumberException;
import com.exceptions.FieldIsRequiredException;
import com.logicLayer.CustomerLogic;
import com.util.OutPutGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

        try {
            LegalCustomer legalCustomer = CustomerLogic.CreateCustomer(companyName, dateOfRegistration, economicCode);
            outputHTML =OutPutGenerator.generate(legalCustomer);
        }catch (FieldIsRequiredException | AssignCustomerNumberException | SQLException e){
            outputHTML = OutPutGenerator.generate(e.getMessage());
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);

    }

}
