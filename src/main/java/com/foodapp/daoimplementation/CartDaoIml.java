package com.foodapp.daoimplementation;


import com.foodapp.dao.Cart;
import com.foodapp.model.CartItem;
import com.util.Dbconnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CartDaoIml implements Cart {

    private static final String INSERT_ITEM = "INSERT INTO cart (userId, menuId, itemname, price, quantity, restaurantId) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ITEM = "UPDATE cart SET quantity = ?, price = ? WHERE userId = ? AND menuId = ?";
    private static final String DELETE_ITEM = "DELETE FROM cart WHERE userId = ? AND menuId = ?";
    private static final String GET_CART_BY_USER = "SELECT * FROM cart WHERE userId = ?";

    @Override
    public void addItem(int userId, CartItem item) {
        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_ITEM)) {

            ps.setInt(1, userId);
            ps.setInt(2, item.getMenuId());
            ps.setString(3, item.getItemname());
            ps.setFloat(4, item.getPrice());
            ps.setInt(5, item.getQuantity());
            ps.setInt(6, item.getRestaurantId());

            ps.executeUpdate();
            System.out.println("Cart item added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(int userId, CartItem item) {
        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_ITEM)) {

            ps.setInt(1, item.getQuantity());
            ps.setFloat(2, item.getPrice());
            ps.setInt(3, userId);
            ps.setInt(4, item.getMenuId());

            ps.executeUpdate();
            System.out.println("Cart item updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(int userId, int menuId) {
        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_ITEM)) {

            ps.setInt(1, userId);
            ps.setInt(2, menuId);

            ps.executeUpdate();
            System.out.println("Cart item deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Integer, CartItem> getCartItemsByUserId(int userId) {
        Map<Integer, CartItem> cartMap = new HashMap<>();

        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_CART_BY_USER)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CartItem item = new CartItem(
                    rs.getInt("menuId"),
                    rs.getString("itemname"),
                    rs.getFloat("price"),
                    rs.getInt("quantity"),
                    rs.getInt("restaurantId")
                );
                cartMap.put(item.getMenuId(), item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartMap;
    }


	
}
