package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.UserController;
import com.revature.util.Logger;


@WebServlet("/UserLogServlet")
public class UserLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	private static final Logger logger=Logger.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneNumber = request.getParameter("phoneNumber");
        String password=request.getParameter("password");
        logger.info(phoneNumber);
        logger.info(password);
		UserController uc=new UserController();
        String json=uc.login(phoneNumber,password);
        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();
        
    }
		
	}
