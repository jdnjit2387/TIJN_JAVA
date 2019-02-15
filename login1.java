/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jhona Davied D souza
 */
public class login1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html");  
  PrintWriter out = response.getWriter();
        String uname=request.getParameter("uname");
        String pass=request.getParameter("pass");
        MyDb db = new MyDb();
        Connection con=db.getCon();
        try {
            Statement stmt=con.createStatement();
            int executeUpdate = stmt.executeUpdate("Insert into user (name,pass) values ('"+uname+"','"+pass+"')");
            if(executeUpdate>0)
                out.print("You are successfully registered...");  
        } catch (SQLException ex) {
            Logger.getLogger(login1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

     
