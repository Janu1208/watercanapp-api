package com.revature.controller;

import java.util.List;

import com.google.gson.JsonObject;
import com.revature.model.Stock;
import com.revature.service.AdminServices;

public class StockController {
public List<Stock> viewStock()
{
    List<Stock> list = null;
    AdminServices as = new AdminServices();
    try {
		list=as.stockView();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
public static String updateStock(int addCans)
{
	String errorMessage = null;
	String message = null;
	try{
	AdminServices as=new AdminServices();
	as.setAvailableCans(addCans);
	message = "Success";
	}
	catch(Exception e)
	{
		errorMessage = e.getMessage();
	}
	JsonObject obj = new JsonObject();
	if (message != null) {

		obj.addProperty("message", message);
	} else if (errorMessage != null) {
		obj.addProperty("errorMessage", errorMessage);
	}
	return obj.toString();

}
public static void main(String args[])
{
	String sc=updateStock(20);
	System.out.println(sc);
}
}