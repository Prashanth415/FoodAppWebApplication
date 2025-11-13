package com.foodapp.daoimplementation;

import com.foodapp.dao.OrderItemDao;
import com.foodapp.model.OrderItem;
import com.util.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {

    private static final String INSERT_ITEM = "INSERT INTO `order_items` (`orderId`, `menuId`, `quantity`, `totalamount`) VALUES (?, ?, ?, ?)";
    private static final String GET_BY_ORDER_ID = "SELECT * FROM `order_items` WHERE `orderId` = ?";

    @Override
    public void addOrderItems(List<OrderItem> items) {
        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_ITEM)) {

            for (OrderItem item : items) {
                ps.setInt(1, item.getOrderId());
                ps.setInt(2, item.getMenuId());
                ps.setInt(3, item.getQuantity());
                ps.setFloat(4, item.getTotalamount());
                ps.addBatch();
            }
            ps.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItem> getItemsByOrderId(int orderId) {
        List<OrderItem> itemList = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_BY_ORDER_ID)) {

            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                itemList.add(new OrderItem(
                    rs.getInt("orderitemId"),
                    rs.getInt("orderId"),
                    rs.getInt("menuId"),
                    rs.getInt("quantity"),
                    rs.getFloat("totalamount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }
}