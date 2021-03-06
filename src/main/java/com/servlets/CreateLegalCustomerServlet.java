package com.servlets;

import com.dataAccessLayer.Beans.LegalCustomer;
import com.exceptions.AssignCustomerNumberException;
import com.exceptions.DuplicateInformationException;
import com.exceptions.FieldIsRequiredException;
import com.logicLayer.CustomerLogic;
import com.util.OutputGenerator;

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
            outputHTML =OutputGenerator.generate(legalCustomer);
        }catch (FieldIsRequiredException | AssignCustomerNumberException | SQLException | DuplicateInformationException e){
            outputHTML = OutputGenerator.generate(e.getMessage());
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);

    }

}
