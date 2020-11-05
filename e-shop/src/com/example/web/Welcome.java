package com.example.web;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Welcome extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Product has been logged in succesfully!<br>");


        String barcode = request.getParameter("Barcode");
        out.println("<br>Item with barcode:"+barcode);
        String name = request.getParameter("Name");
        out.println("<br>Item with name:"+name);
        String color = request.getParameter("Color");
        out.println("<br>Item with color:"+color);
        String description = request.getParameter("Description");
        out.println("<br>Item with description:"+description);
      }  
}