package com.revature.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.model.User;
import com.revature.service.UserServices;

public class UserController {

	public String register(String name, String phoneNumber, String password)  {
		String errorMessage = null;
		String message = null;
		User user = null;
		try {
			user = new User();
			user.setName(name);
			user.setPhoneNumber(phoneNumber);
			user.setPassword(password);
			UserServices us = new UserServices();

			us.register(user);
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
	public String login(String phoneNumber,String password)
	{
		String errorMessage = null;
        User user  = null;
        try {
			UserServices us = new UserServices();
            user=us.login(phoneNumber, password);             
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }       
         
        String json = null;
        Gson gson = new Gson();
        if( user != null) {
             json = gson.toJson(user);
             
        }
        else if ( user == null ) {
            JsonObject obj = new JsonObject();
            obj.addProperty("errorMessage", errorMessage);
            json = obj.toString();
        }
         
         
        return json;
         
		
		
	}
	
}