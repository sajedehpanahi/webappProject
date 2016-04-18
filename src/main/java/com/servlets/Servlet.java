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
@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstInput = request.getParameter("firstInput");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>\n" +
                "<head>\n" +
                "<title>Servlet Example</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>This is heading 1</h1>\n" +
                "<h2>"+firstInput+"</h2>\n" +
                "<h3>This is heading 3</h3>\n" +
                "<h4>This is heading 4</h4>\n" +
                "<h5>This is heading 5</h5>\n" +
                "<h6>This is heading 6</h6>\n" +
                "</body>\n" +
                "</html>");
       // printWriter.println("hello from servlet");


    }
}
