package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.UserController;


@WebServlet("/UserLogServlet")
public class UserLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone_number = request.getParameter("phone_number");
        String password=request.getParameter("password");
        //System.out.println(phone_number);
        //System.out.println(password);
		UserController uc=new UserController();
        String json=uc.login(phone_number,password);
		/*HttpSession session = request.getSession(false);
		session.setAttribute("USER_ID",json);*/
        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();
        
    }
		
	}

	
	


