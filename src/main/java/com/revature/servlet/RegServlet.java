package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.UserController;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		UserController uc = new UserController();
		String json = uc.register(name, phoneNumber, password);
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}

}