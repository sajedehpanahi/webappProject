package com.servlets;

import com.exceptions.DataBaseConnectionException;
import com.logicLayer.CustomerLogic;
import com.logicLayer.LegalCustomerLogic;
import com.util.OutputGenerator;
import com.util.OutputGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "DeleteLegalCustomerServlet")
public class DeleteLegalCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String outputHTML = "";
        try {
            LegalCustomerLogic.deleteById(id);
            outputHTML = OutputGenerator.generateSuccess("مشتری با موفقیت حذف شد.","legal");
        } catch (SQLException e) {
            outputHTML = OutputGenerator.generate(e.getMessage());
        } catch (DataBaseConnectionException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(outputHTML);
    }
}
