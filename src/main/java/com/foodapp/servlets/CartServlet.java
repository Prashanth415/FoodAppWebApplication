package com.foodapp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menuIdStr = request.getParameter("menuId");
        String itemname = request.getParameter("itemname");
        String priceStr = request.getParameter("price");
        String quantityStr = request.getParameter("quantity");
        String restaurantIdStr = request.getParameter("restaurantId");

        if (menuIdStr == null || itemname == null || priceStr == null || quantityStr == null || restaurantIdStr == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing input parameters.");
            return;
        }

        try {
            int menuId = Integer.parseInt(menuIdStr);
            float price = Float.parseFloat(priceStr);
            int quantity = Integer.parseInt(quantityStr);
            int restaurantId = Integer.parseInt(restaurantIdStr);

            HttpSession session = request.getSession();
            List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
            Integer currentRestaurantId = (Integer) session.getAttribute("restaurantId");

            // Restore previous cart after order placement if available
            if (cartItems == null) {
                cartItems = (List<CartItem>) session.getAttribute("previousCartItems");
                if (cartItems == null) {
                    cartItems = new ArrayList<>();
                }
                session.setAttribute("cartItems", cartItems);
            }

            // Prevent mixing items from different restaurants
            if (currentRestaurantId != null && currentRestaurantId != restaurantId) {
                cartItems.clear();
            }

            session.setAttribute("restaurantId", restaurantId);

            // Check if the item already exists in the cart
            boolean found = false;
            for (CartItem item : cartItems) {
                if (item.getMenuId() == menuId) {
                    item.setQuantity(item.getQuantity() + quantity);
                    found = true;
                    break;
                }
            }

            // Add new item if not found
            if (!found) {
                cartItems.add(new CartItem(menuId, itemname, price, quantity, restaurantId));
            }

            session.setAttribute("cartItems", cartItems);
            response.sendRedirect("Cart.jsp");

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format.");
        }
    }
}