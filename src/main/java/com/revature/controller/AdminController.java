package com.revature.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.model.Admin;
import com.revature.service.AdminServices;

public class AdminController {
	public String login(String Name,String Password)
	{
		String errorMessage = null;
       Admin admin  = null;
        try {
			AdminServices as = new AdminServices();
			admin=as.login(Name, Password);             
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }       
         
        String json = null;
        Gson gson = new Gson();
        if( admin != null) {
             json = gson.toJson(admin);
             
        }
        else if ( admin == null ) {
            JsonObject obj = new JsonObject();
            obj.addProperty("errorMessage", errorMessage);
            json = obj.toString();
        }
         
         
        return json;
         
		
		
	}
}