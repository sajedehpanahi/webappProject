package com.servlets;

import com.dataAccessLayer.Beans.RealCustomer;
import com.logicLayer.RealCustomerLogic;
import com.util.OutputGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UpdateRealCustomerServlet")
public class UpdateRealCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String outputHTML="";
        try {
            RealCustomer realCustomer = RealCustomerLogic.retrieveCustomerById(id);
            outputHTML = OutputGenerator.generateUpdatePage(realCustomer);
        } catch (SQLException e) {
            outputHTML = OutputGenerator.generate(e.getMessage());
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);

    }
}
