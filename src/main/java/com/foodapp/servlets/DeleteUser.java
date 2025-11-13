package com.foodapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.foodapp.daoimplementation.UserDaoIml;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteUser extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException {
		
		int userId=Integer.parseInt(req.getParameter("userId"));
		
		UserDaoIml userdao=new UserDaoIml();
		userdao.deleteUser(userId);
		
		PrintWriter out = resp.getWriter();
		
		out.println("User Deleted Successfully");
	}
	

}
