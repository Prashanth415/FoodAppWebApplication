package com.foodapp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.foodapp.dao.*;
import com.foodapp.daoimplementation.OrderDaoImpl;
import com.foodapp.daoimplementation.OrderItemDaoImpl;
import com.foodapp.model.CartItem;
import com.foodapp.model.Order;
import com.foodapp.model.OrderItem;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        Integer userId = (Integer) session.getAttribute("userId");
        Integer restaurantId = (Integer) session.getAttribute("restaurantId");

        if (userId == null || cartItems == null || cartItems.isEmpty()) {
            response.sendRedirect("UserLogin.jsp");
            return;
        }

        float totalAmount = 0;
        for (CartItem item : cartItems) {
            totalAmount += item.getTotalPrice();
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setRestaurantId(restaurantId);
        order.setOrderDate(new java.util.Date());
        order.setTotalamount(totalAmount);
        order.setStatus("PLACED");
        order.setPaymentmode("CASH"); // You can allow users to choose later

        OrderDao orderDao = new OrderDaoImpl();
        int newOrderId = orderDao.createOrder(order);
        
        

        if (newOrderId > 0) {
        	OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        	List<OrderItem> orderItemList = new ArrayList<>();

        	for (CartItem cartItem : cartItems) {
        	    OrderItem orderItem = new OrderItem();
        	    orderItem.setOrderId(newOrderId);
        	    orderItem.setMenuId(cartItem.getMenuId());
        	    orderItem.setQuantity(cartItem.getQuantity());
        	    orderItem.setTotalamount(cartItem.getTotalPrice());
        	    orderItemList.add(orderItem);
        	}
        	orderItemDao.addOrderItems(orderItemList);

            session.setAttribute("previousCartItems", new ArrayList<>(cartItems)); // optional
            session.removeAttribute("cartItems");
            session.removeAttribute("restaurantId");
            response.sendRedirect("OrderConfirmation.jsp?orderId=" + newOrderId);
        } else {
            response.sendRedirect("Cart.jsp?error=failed");
        }
    }

}