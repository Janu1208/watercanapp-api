package com.revature.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.controller.StockController;
import com.revature.model.Stock;

@WebServlet("/ViewStockServlet")
public class ViewStockServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
    StockController sc=new StockController();
    List<Stock> list =sc.viewStock();
    Gson gson = new Gson();
    String json = gson.toJson(list);  
    PrintWriter out = response.getWriter();
    out.println(json);
    out.flush();
    }
    
}