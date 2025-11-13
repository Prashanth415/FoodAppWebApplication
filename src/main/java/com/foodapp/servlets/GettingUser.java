package com.foodapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.foodapp.daoimplementation.UserDaoIml;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GettingUser extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		int userId=Integer.parseInt(req.getParameter("userId"));
		
		UserDaoIml userdao=new UserDaoIml();
		User user=userdao.getUser(userId);
		PrintWriter out=resp.getWriter();
		if(user!=null) {
			out.println("User Details: "+user.toString());
		}
		else {
			out.println("User not found");
		}
		
	}

}
