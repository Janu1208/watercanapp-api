package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.ReserveController;
import com.revature.model.Reserve;


@WebServlet("/ReserveCanServlet")
public class ReserveCanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reserveCans=request.getParameter("reserveCans");
		 int canReserve = Integer.parseInt(reserveCans);
		 Reserve reserve =new Reserve();
	     int userId= Integer.parseInt((request.getParameter("userId")));
         reserve.setUserId(userId);
         reserve.setReserveCans(canReserve);
         ReserveController rc=new ReserveController();
         String json=rc.reserveCans(reserve);
         PrintWriter out=response.getWriter();
			out.print(json);
			out.flush();
	
	}



}