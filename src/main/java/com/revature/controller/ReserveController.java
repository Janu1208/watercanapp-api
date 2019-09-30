package com.revature.controller;

import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.model.Reserve;
import com.revature.service.ReserveServices;

public class ReserveController {
	public  String reserveCans(Reserve reserve)
	{
		String errorMessage = null;

		 try{
			 ReserveServices rs=new ReserveServices();
			reserve=rs.reserveCan(reserve);
			 if(reserve==null)
			 {
					throw new SQLException("Invalid cans...please check available stock and re enter the value");

			 }
				
	}  catch (Exception e) {
        errorMessage = e.getMessage();
    }
    String json = null;
    Gson gson = new Gson();
    if (reserve != null) {
        json = gson.toJson(reserve);
    } else if (reserve == null) {
        JsonObject obj = new JsonObject();
        obj.addProperty("errorMessage", errorMessage);
        json = obj.toString();
    }
    return json;
}
}

