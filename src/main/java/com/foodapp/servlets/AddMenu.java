package com.foodapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.foodapp.daoimplementation.MenuDaoIml;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddMenu extends HttpServlet{
	
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
        String itemname = req.getParameter("itemname");
        String description = req.getParameter("description");
        float price = Float.parseFloat(req.getParameter("price"));
        String isavailable = req.getParameter("isavailable");
        float rating = Float.parseFloat(req.getParameter("rating"));
        String imagepath = req.getParameter("imagepath");

        Menu menuItem = new Menu(0, restaurantId, itemname, description, price, isavailable, rating, imagepath);
        
        MenuDaoIml menuDao = new MenuDaoIml();
        menuDao.addMenuItem(menuItem);

        PrintWriter out = resp.getWriter();
        out.println("Menu item '" + itemname + "' added successfully!");
    }


}
