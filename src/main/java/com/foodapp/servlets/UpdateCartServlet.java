package com.foodapp.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.foodapp.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateCart")
public class UpdateCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int menuId = Integer.parseInt(request.getParameter("menuId"));
        String action = request.getParameter("action");

        HttpSession session = request.getSession();
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");

        if (cartItems != null) {
            Iterator<CartItem> iterator = cartItems.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getMenuId() == menuId) {
                    if (action.equals("+")) {
                        item.setQuantity(item.getQuantity() + 1);
                    } else if (action.equals("-")) {
                        item.setQuantity(item.getQuantity() - 1);
                        if (item.getQuantity() <= 0) {
                            iterator.remove();
                        }
                    }
                    break;
                }
            }
        }

        response.sendRedirect("Cart.jsp");
    }
}
