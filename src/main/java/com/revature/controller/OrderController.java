package com.revature.controller;

import com.google.gson.JsonObject;
import com.revature.model.Order;
import com.revature.service.OrderService;

public class OrderController {
public  String orderCans(Order order)
{
	String errorMessage = null;
	String message = null;

	 OrderService us=new OrderService();
	 try{
	 us.orderCan(order);		
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
