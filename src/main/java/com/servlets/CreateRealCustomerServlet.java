package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by DotinSchool2 on 4/18/2016.
 */
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

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>\n" +
                "<head>\n" +
                "<title>Servlet Example</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Real Customer Information!</h1>\n" +
                "<h2>"+firstName+"</h2>\n" +
                "<h2>"+lastName+"</h2>\n" +
                "<h2>"+fatherName+"</h2>\n" +
                "<h2>"+dateOfBirth+"</h2>\n" +
                "<h2>"+nationalCode+"</h2>\n" +
                "</body>\n" +
                "</html>");

    }
}
