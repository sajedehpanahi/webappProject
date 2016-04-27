package com.servlets;

import com.dataAccessLayer.Beans.RealCustomer;
import com.exceptions.AssignCustomerNumberException;
import com.exceptions.DateFormatException;
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

@WebServlet(name = "CreateRealCustomerServlet")
public class CreateRealCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String fatherName = request.getParameter("fatherName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String nationalCode = request.getParameter("nationalCode");
        String outputHTML = "";

        try {
            RealCustomer realCustomer = CustomerLogic.CreateCustomer(firstName, lastName, fatherName, dateOfBirth, nationalCode);
            outputHTML = OutputGenerator.generate(realCustomer);
        } catch (FieldIsRequiredException | DateFormatException | AssignCustomerNumberException | SQLException | DuplicateInformationException e) {
            outputHTML = OutputGenerator.generate(e.getMessage());
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);

    }
}
