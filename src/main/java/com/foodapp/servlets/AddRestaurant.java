package com.foodapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;

import com.foodapp.model.Restaurant;
import com.foodapp.daoimplementation.RestaurantDaoIml;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
	

	public class AddRestaurant extends HttpServlet {

	    @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	        String name = req.getParameter("name");
	        String address = req.getParameter("address");
	        String phonenumber = req.getParameter("phonenumber");
	        String cuisineType = req.getParameter("cuisineType");
	        String deliveryTimeParam = req.getParameter("deliveryTime");
	        Time deliveryTime = (deliveryTimeParam != null && !deliveryTimeParam.isEmpty()) ? Time.valueOf(deliveryTimeParam) : null;

	        String adminUserIdParam = req.getParameter("adminuserId");
	        int adminUserId = (adminUserIdParam != null && !adminUserIdParam.isEmpty()) ? Integer.parseInt(adminUserIdParam) : 0;
	        //int adminUserId = Integer.parseInt(req.getParameter("adminUserId"));

	        String ratingParam = req.getParameter("rating");
	        float rating = 0.0f;
	        if (ratingParam != null && !ratingParam.trim().isEmpty()) {
	            try {
	                rating = Float.parseFloat(ratingParam.trim());
	            } catch (NumberFormatException e) {
	                rating = 0.0f;
	            }
	        }

	        String imagepath = req.getParameter("imagepath");
	        

	        Restaurant restaurant = new Restaurant(0,name,address,phonenumber,cuisineType,deliveryTime,adminUserId,rating,imagepath);
	        RestaurantDaoIml restaurantDao = new RestaurantDaoIml();

	        restaurantDao.addRestaurant(restaurant);

	        PrintWriter out = resp.getWriter();
	        out.println("Restaurant '" + name + "' registered successfully!");

	    }
	}


