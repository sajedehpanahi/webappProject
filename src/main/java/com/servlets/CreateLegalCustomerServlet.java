package com.servlets;

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

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>\n" +
                "<head>\n" +
                "<title>Servlet Example</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Real Customer Information!</h1>\n" +
                "<h2>" + companyName + "</h2>\n" +
                "<h2>" + dateOfRegistration + "</h2>\n" +
                "<h2>" + economicCode + "</h2>\n" +
                "</body>\n" +
                "</html>");

    }

}
