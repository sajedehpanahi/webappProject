package com.servlets;

import com.dataAccessLayer.Beans.LegalCustomer;
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

@WebServlet(name = "SearchLegalCustomerServlet")
public class SearchLegalCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerNumber = request.getParameter("customerNumber");
        String companyName = request.getParameter("companyName");
        String dateOfRegistration = request.getParameter("dateOfRegistration");
        String economicCode = request.getParameter("economicCode");
        String outputHTML="";
        try {
            ArrayList<LegalCustomer> legalCustomers = CustomerLogic.retrieveCustomer(customerNumber, companyName, dateOfRegistration, economicCode);
            if(legalCustomers.size() == 0){
                outputHTML = OutputGenerator.generateSuccess("مشتری با اطلاعات وارد شده وجود ندارد.", "legal");
            }else {
                outputHTML = OutputGenerator.generateLegalCustomerResult(legalCustomers);
            }
        }catch (SQLException e){
            outputHTML = OutputGenerator.generate(e.getMessage());
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);

    }
}
