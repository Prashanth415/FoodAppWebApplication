package com.foodapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import com.foodapp.model.User;
import com.foodapp.daoimplementation.UserDaoIml;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/callingRegisterServlet")
public class UserRegister extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp ) throws ServletException ,IOException {
		
		String name = req.getParameter("name");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email= req.getParameter("email");
		String phonenumber=req.getParameter("phonenumber");
		String address=req.getParameter("address");
		String role = req.getParameter("role").trim();
		List<String> allowedRoles = Arrays.asList("Admin", "RestaurantOwner", "Customer", "DeliveryPartner");
	    if (!allowedRoles.contains(role)) {
	        throw new IllegalArgumentException("Invalid role: " + role);
	    }
		
		User user= new User(0, name,username,password,email,phonenumber,address,role, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
		UserDaoIml userdao = new UserDaoIml();
		
		userdao.addUser(user);
		
		PrintWriter out=resp.getWriter();
		
		out.println("Hi "+ name +" registration successfull");
		resp.sendRedirect("UserLogin.jsp");
		
	}
	
}





