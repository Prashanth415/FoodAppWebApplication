package com.foodapp.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.MenuInterface;
import com.foodapp.model.Menu;
import com.util.Dbconnection;

public class MenuDaoIml implements MenuInterface {

    private static final String INSERT_QUERY =
        "INSERT INTO menu (restaurant_id, item_name, description, price, is_available, rating, image_path) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    private static final String GET_QUERY =
        "SELECT * FROM menu WHERE menu_id = ?";
    
    private static final String UPDATE_QUERY =
        "UPDATE menu SET restaurant_id = ?, item_name = ?, description = ?, price = ?, is_available = ?, rating = ?, image_path = ? WHERE menu_id = ?";
    
    private static final String DELETE_QUERY =
        "DELETE FROM menu WHERE menu_id = ?";
    
    private static final String GET_ALL_QUERY =
        "SELECT * FROM menu";
    
    private static final String GET_BY_RESTAURANT_QUERY =
        "SELECT * FROM menu WHERE restaurant_id = ?";

    @Override
    public void addMenuItem(Menu menu) {
        try (Connection connection = Dbconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {

            ps.setInt(1, menu.getRestaurantId());
            ps.setString(2, menu.getItemname());
            ps.setString(3, menu.getDescription());
            ps.setFloat(4, menu.getPrice());
            ps.setString(5, menu.isIsavailable());
            ps.setFloat(6, menu.getRating());
            ps.setString(7, menu.getImagepath());

            ps.executeUpdate();
            System.out.println("✅ Menu item added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu getMenuItem(int menuId) {
        Menu menu = null;
        try (Connection connection = Dbconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_QUERY)) {

            ps.setInt(1, menuId);
            ResultSet res = ps.executeQuery();

            if (res.next()) {
                menu = new Menu(
                    res.getInt("menu_id"),
                    res.getInt("restaurant_id"),
                    res.getString("item_name"),
                    res.getString("description"),
                    res.getFloat("price"),
                    res.getString("is_available"),
                    res.getFloat("rating"),
                    res.getString("image_path")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public void updateMenuItem(Menu menu) {
        try (Connection connection = Dbconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {

            ps.setInt(1, menu.getRestaurantId());
            ps.setString(2, menu.getItemname());
            ps.setString(3, menu.getDescription());
            ps.setFloat(4, menu.getPrice());
            ps.setString(5, menu.isIsavailable());
            ps.setFloat(6, menu.getRating());
            ps.setString(7, menu.getImagepath());
            ps.setInt(8, menu.getMenuId());

            ps.executeUpdate();
            System.out.println("✅ Menu item updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenuItem(int menuId) {
        try (Connection connection = Dbconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {

            ps.setInt(1, menuId);
            ps.executeUpdate();
            System.out.println("🗑️ Menu item deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> getAllMenuItems() {
        List<Menu> menuList = new ArrayList<>();
        try (Connection connection = Dbconnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet res = stmt.executeQuery(GET_ALL_QUERY)) {

            while (res.next()) {
                menuList.add(new Menu(
                    res.getInt("menu_id"),
                    res.getInt("restaurant_id"),
                    res.getString("item_name"),
                    res.getString("description"),
                    res.getFloat("price"),
                    res.getString("is_available"),
                    res.getFloat("rating"),
                    res.getString("image_path")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public List<Menu> getAllMenuByRestaurantId(int restaurantId) {
        List<Menu> menuList = new ArrayList<>();

        try (Connection connection = Dbconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_BY_RESTAURANT_QUERY)) {

            ps.setInt(1, restaurantId);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                Menu menu = new Menu(
                    res.getInt("menu_id"),
                    res.getInt("restaurant_id"),
                    res.getString("item_name"),
                    res.getString("description"),
                    res.getFloat("price"),
                    res.getString("is_available"),
                    res.getFloat("rating"),
                    res.getString("image_path")
                );
                menuList.add(menu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuList;
    }
}
