
package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Order;



public interface OrderDao {
    int createOrder(Order order);
    List<Order> getOrdersByUserId(int userId);
}