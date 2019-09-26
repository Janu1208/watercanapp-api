package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.AdminController;
import com.revature.util.Logger;



@WebServlet("/AdminServlet")

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger=Logger.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String Name = request.getParameter("Name");
        String Password=request.getParameter("Password");
        logger.info(Name);
        logger.info(Password);
        AdminController ac=new AdminController();
        String json=ac.login(Name,Password);
        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();
        
	}

	
	
}