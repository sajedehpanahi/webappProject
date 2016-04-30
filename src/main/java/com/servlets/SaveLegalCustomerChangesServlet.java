package com.servlets;

import com.exceptions.DataBaseConnectionException;
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

@WebServlet(name = "SaveLegalCustomerChangesServlet")
public class SaveLegalCustomerChangesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String companyName = request.getParameter("companyName");
        String dateOfRegistration = request.getParameter("dateOfRegistration");
        String economicCode = request.getParameter("economicCode");
        String outputHTML="";

        try {
            CustomerLogic.updateCustomer(id, companyName, dateOfRegistration, economicCode);
            outputHTML = OutputGenerator.generateSuccess("اطلاعات مشتری با موفقیت اطلاح شد.","legal");
        } catch (SQLException | DataBaseConnectionException e){
            outputHTML = OutputGenerator.generate(e.getMessage());
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);

    }
}
