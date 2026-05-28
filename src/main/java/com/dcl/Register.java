package com.dcl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet{
	
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    String name=req.getParameter("name");
    String job=req.getParameter("job");
    Double sal=Double.parseDouble(req.getParameter("sal"));
    Integer dno=Integer.parseInt(req.getParameter("dno"));
    String mail=req.getParameter("mail");
    String password=req.getParameter("password");
    String confirm=req.getParameter("confirm");
    
    String query="INSERT INTO EMPLOYEE VALUES (0,?,?,?,?,SYSDATE(),?,?)";
    if(password.equals(confirm)) {
        int i=0;
        try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empl_data","root","vsk@2004");
    		PreparedStatement p=con.prepareStatement(query);
    		p.setString(1, name);
    		p.setString(2, job);
    		p.setDouble(3, sal);
    		p.setInt(4, dno);
    		p.setString(5, mail);
    		p.setString(6, password);
    		i=p.executeUpdate();
    	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	}
        
        if(i>0) {
    		resp.getWriter().println("<h1>Data added successfully</h1>");
    	} else {
    		resp.getWriter().println("<h1>Failed to add the data</h1>");
    	}
    	
    } else {
    	resp.getWriter().println("<h1>ReEnter the password</h1>");
    }

    
    	
    }
}
