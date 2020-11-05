package com.example.web;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String barcode = request.getParameter("Barcode");
       // out.println("<br>Got this in ther servlet(barcode):"+barcode);
        String name = request.getParameter("Name");
       // out.println("<br>Got this in ther servlet(name):"+name);
        String color = request.getParameter("Color");
       // out.println("<br>Got this in ther servlet(color):"+color);
        String description = request.getParameter("Description");
        //out.println("<br>Got this in ther servlet(description):"+description);


         boolean st =false;
        try {
            
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            
            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_shop","root","05121998");
            RequestDispatcher rs;
            

            PreparedStatement ps = con.prepareStatement("select * from items where items_id=? ");
            ps.setString(1, barcode);
            
            ResultSet res =ps.executeQuery();
            
             if( res.next() == false)   {
                out.println("dn uparxei sthn db ara to grafw");
                 ps = con.prepareStatement("insert into items values(?,?,?,?)");

                 ps.setString(1, barcode);
                ps.setString(2, name);
                ps.setString(3, color);
                ps.setString(4, description);
                int i = ps.executeUpdate();
                if(i > 0) {
                
                 rs = request.getRequestDispatcher("Welcome");
                rs.forward(request, response);
                 }
            }
            else{
                out.println("Barcode already exists try another one");
                 rs = request.getRequestDispatcher("form.html");
                rs.include(request, response);
            }
            
             
            
        }
        catch(Exception e) {
            out.println("mphka sto catch");
            e.printStackTrace();
        }
        
        
      
       
    }

    
}   