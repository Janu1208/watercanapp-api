package com.revature.controller;

import com.google.gson.JsonObject;
import com.revature.model.Reserve;
import com.revature.service.ReserveServices;

public class ReserveController {
	public  String reserveCans(Reserve reserve)
	{
		String errorMessage = null;
		String message = null;

		 ReserveServices rs=new ReserveServices();
		 try{
		 rs.reserveCan(reserve);		
		 message = "Success";
	} catch (Exception e) {
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
}