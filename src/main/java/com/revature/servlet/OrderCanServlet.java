package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.OrderController;
import com.revature.model.Order;

@WebServlet("/OrderCanServlet")
public class OrderCanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order=null;
		 
		 String orderCan=request.getParameter("orderCan");
		 int canOrder = Integer.parseInt(orderCan);
		  order=new Order();

		
			int userId= Integer.parseInt((request.getParameter("userId")));
		    
			order.setUserId(userId);
			order.setOrderCans(canOrder);
			OrderController oc=new OrderController();
			String json=oc.orderCans(order);
			PrintWriter out=response.getWriter();
			out.print(json);
			out.flush();
		 }
		
		
	}


