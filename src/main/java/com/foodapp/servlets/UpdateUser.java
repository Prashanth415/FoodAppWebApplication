package com.foodapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.foodapp.daoimplementation.UserDaoIml;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateUser extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException ,ServletException{
		String userIdStr = req.getParameter("userId");
	    if (userIdStr == null || userIdStr.trim().isEmpty()) {
	        resp.getWriter().println("Invalid user ID provided.");
	        return;
	    }

		int userId = Integer.parseInt(req.getParameter("userId"));
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phonenumber = req.getParameter("phonenumber");
        String address = req.getParameter("address");
        String role = req.getParameter("role");

        User user= new User(userId,name,username,email,password,phonenumber,address,role, null, null);
        UserDaoIml userdao=new UserDaoIml();
        userdao.updateUser(user);
        
        PrintWriter out= resp.getWriter();
        out.println("User Updated Sucessfully");
	}

}
