package com.foodapp.daoimplementation;


import com.foodapp.dao.OrderDao;
import com.foodapp.model.Order;
import com.util.Dbconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class OrderDaoImpl implements OrderDao {
    
    private static final String INSERT_ORDER = "INSERT INTO `orders` (`restaurantId`, `userId`, `orderDate`, `totalamount`, `status`, `paymentmode`) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_ORDERS_BY_USER = "SELECT * FROM `orders` WHERE `userId` = ?";

    @Override
    public int createOrder(Order order) {
        int orderId = -1;
        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {
             
            ps.setInt(1, order.getRestaurantId());
            ps.setInt(2, order.getUserId());
            ps.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            ps.setFloat(4, order.getTotalamount());
            ps.setString(5, order.getStatus());
            ps.setString(6, order.getPaymentmode());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                orderId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_ORDERS_BY_USER)) {
             
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                orders.add(new Order(
                    rs.getInt("orderId"),
                    rs.getInt("restaurantId"),
                    rs.getInt("userId"),
                    rs.getDate("orderDate"),
                    rs.getFloat("totalamount"),
                    rs.getString("status"),
                    rs.getString("paymentmode")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}