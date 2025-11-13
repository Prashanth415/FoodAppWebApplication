package com.foodapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.foodapp.daoimplementation.UserDaoIml;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetAllUsers extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		UserDaoIml userDao = new UserDaoIml();
        List<User> userList = userDao.getAllUsers();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>All Users</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; text-align: center; background: #f8f9fa; }");
        out.println(".container { width: 80%; margin: auto; background: white; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.3); }");
        out.println("table { border-collapse: collapse; width: 100%; }");
        out.println("th, td { border: 1px solid black; padding: 10px; text-align: left; }");
        out.println("th { background-color: #007bff; color: white; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<h2>Registered Users</h2>");
        out.println("<table>");
        out.println("<tr><th>User ID</th><th>Name</th><th>Username</th><th>Email</th><th>Phone Number</th><th>Address</th><th>Role</th></tr>");

        if (userList.isEmpty()) {
            out.println("<tr><td colspan='7'>No users found.</td></tr>");
        } else {
            for (User user : userList) {
                out.println("<tr>");
                out.println("<td>" + user.getUserId() + "</td>");
                out.println("<td>" + user.getName() + "</td>");
                out.println("<td>" + user.getUsername() + "</td>");
                out.println("<td>" + user.getEmail() + "</td>");
                out.println("<td>" + user.getPhonenumber() + "</td>");
                out.println("<td>" + user.getAddress() + "</td>");
                out.println("<td>" + user.getRole() + "</td>");
                out.println("</tr>");
            }
        }

        out.println("</table>");
        out.println("</div>");
        out.println("</body></html>");
    }


	}

