package com.foodapp.servlets;

import java.io.IOException;
import java.util.List;

import com.foodapp.daoimplementation.MenuDaoIml;
import com.foodapp.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/Menu")
public class MenuServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	
    	String rid = req.getParameter("restaurantId");
    	int restaurantId = 0;
    	if (rid != null && !rid.trim().isEmpty()) {
    	    restaurantId = Integer.parseInt(rid.trim());
    	} else {
    	    // Handle error, e.g. redirect or log
    	    resp.sendRedirect("HomeServlet?error=Invalid restaurantId");
    	    return;
    	}

    	
        MenuDaoIml dao =new MenuDaoIml();
        
		List<Menu> allMenusByRestaurant =dao.getAllMenuByRestaurantId(restaurantId);
		for(Menu menus:allMenusByRestaurant) {
			System.out.println(menus);
		}
		req.setAttribute("allMenusByRestaurant", allMenusByRestaurant);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Menu.jsp");
		dispatcher.forward(req, resp);

    }
}
