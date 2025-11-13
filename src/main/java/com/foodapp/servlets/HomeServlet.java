package com.foodapp.servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.foodapp.daoimplementation.RestaurantDaoIml;
import com.foodapp.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(HomeServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            RestaurantDaoIml dao = new RestaurantDaoIml();
            List<Restaurant> restaurants = dao.getAllRestaurants();

            if (restaurants == null || restaurants.isEmpty()) {
                LOGGER.log(Level.WARNING, "No restaurants found.");
            } else {
                LOGGER.log(Level.INFO, "Fetched " + restaurants.size() + " restaurants.");
            }

            req.setAttribute("allRestaurants", restaurants);
            RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error fetching restaurants", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to load restaurants.");
        }
    }
}
