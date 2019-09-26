package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.StockController;



@WebServlet("/UpdateStock")
public class UpdateStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int addCans=Integer.parseInt(request.getParameter("cansAvail"));
	   String json= StockController.updateStock(addCans);  
	    PrintWriter out = response.getWriter();
	    out.println(json);
	    out.flush();
	    


	}
}