package com.foodapp.servlets;

import java.io.IOException;
import java.util.List;

import com.foodapp.daoimplementation.UserDaoIml;
import com.foodapp.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDaoIml dao = new UserDaoIml();
        User user = dao.getUserByUsernameAndPassword(username, password);

        if (user != null) {
            HttpSession session = req.getSession();
            
            // Store user details in the session
            session.setAttribute("loggedInUser", user);
            session.setAttribute("userId", user.getUserId()); // Add this to store user ID
            System.out.println("Session User ID: " + session.getAttribute("userId"));

            // Example attributes (if available from previous order placement)
            Object orderId = session.getAttribute("orderId");
            Object totalAmount = session.getAttribute("totalAmount");

            // Forwarding to OrderSuccess.jsp with attributes
            req.setAttribute("orderId", orderId);
            req.setAttribute("totalAmount", totalAmount);
            RequestDispatcher rd = req.getRequestDispatcher("OrderConfirmation.jsp");
            rd.forward(req, resp);
        }
         else {
            List<User> allUsers = dao.getAllUsers();
            boolean userExists = allUsers.stream().anyMatch(u -> u.getUsername().equals(username));

            if (userExists) {
                req.setAttribute("error", "Invalid password");
            } else {
                req.setAttribute("error", "Username not found. Please register.");
            }

            RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp");
            rd.forward(req, resp);
        }
    }
}
