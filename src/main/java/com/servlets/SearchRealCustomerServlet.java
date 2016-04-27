package com.servlets;

import com.dataAccessLayer.Beans.RealCustomer;
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
import java.util.ArrayList;


@WebServlet(name = "SearchRealCustomerServlet")
public class SearchRealCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerNumber = request.getParameter("customer_number");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String fatherName = request.getParameter("fatherName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String nationalCode = request.getParameter("nationalCode");
        String outputHTML="";
        try {
            ArrayList<RealCustomer> realCustomers = CustomerLogic.retrieveCustomer(customerNumber, nationalCode, firstName,lastName,fatherName,dateOfBirth);
            if(realCustomers.size() == 0){
                outputHTML = OutputGenerator.generateSuccess("مشتری با اطلاعات وارد شده وجود ندارد.");
            }else {
                outputHTML = OutputGenerator.generateRealCustomerResults(realCustomers);
            }
        }catch (SQLException e){
            outputHTML = OutputGenerator.generate(e.getMessage());
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);

    }
}
