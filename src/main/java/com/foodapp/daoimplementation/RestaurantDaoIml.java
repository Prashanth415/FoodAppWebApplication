package com.foodapp.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.RestaurantInterface;
import com.foodapp.model.Restaurant;
import com.util.Dbconnection;

public class RestaurantDaoIml implements RestaurantInterface{

	private static final String INSERT_QUERY = "INSERT INTO `restaurant` (`name`, `address`, `phonenumber`, `cuisineType`, `deliveryTime`, `adminuserId`, `rating`, `imagePath`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_QUERY = "SELECT * FROM `restaurant` WHERE `restaurantId`=?";
    private static final String UPDATE_QUERY = "UPDATE `restaurant` SET `name`=?, `address`=?, `phonenumber`=?, `cuisineType`=?, `deliveryTime`=?, `adminuserId`=?, `rating`=?, `imagePath`=? WHERE `restaurantId`=?";
    private static final String DELETE_QUERY = "DELETE FROM `restaurant` WHERE `restaurantId`=?";
    private static final String GET_ALL_QUERY = "SELECT * FROM `restaurant`";

	@Override
	public void addRestaurant(Restaurant restaurant) {
		
		try (Connection connection = Dbconnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {

			preparedStatement.setString(1, restaurant.getName());
			preparedStatement.setString(2, restaurant.getAddress());
			preparedStatement.setString(3, restaurant.getPhonenumber());
			preparedStatement.setString(4, restaurant.getCuisineType());
			preparedStatement.setTime(5, restaurant.getDeliveryTime());
			preparedStatement.setInt(6, restaurant.getAdminuserId());
			
			preparedStatement.setFloat(7, restaurant.getRating());
			preparedStatement.setString(8, restaurant.getImagepath());

			preparedStatement.executeUpdate();
			System.out.println("Restaurant added successfully!");

        } 
		catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		
		Restaurant restaurant = null;
        try (Connection connection = Dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_QUERY)) {

        	preparedStatement.setInt(1, restaurantId);
            ResultSet res =preparedStatement.executeQuery();

            if (res.next()) {
                restaurant = new Restaurant(
                		res.getInt("restaurantId"), 
                        res.getString("name"),
                        res.getString("address"),
                        res.getString("phonenumber"),
                        res.getString("cuisineType"),
                        res.getTime("deliveryTime"),
                        res.getInt("adminuserId"),
                        res.getFloat("rating"),
                        res.getString("imagePath"));
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {

		try (Connection connection = Dbconnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {

			preparedStatement.setString(1, restaurant.getName());
			preparedStatement.setString(2, restaurant.getAddress());
			preparedStatement.setString(3, restaurant.getPhonenumber());
			preparedStatement.setString(4, restaurant.getCuisineType());
			preparedStatement.setTime(5, restaurant.getDeliveryTime());
			preparedStatement.setInt(6, restaurant.getAdminuserId());
			
			preparedStatement.setFloat(7, restaurant.getRating());
			preparedStatement.setString(8, restaurant.getImagepath());
			preparedStatement.setInt(9, restaurant.getRestaurantId());

			preparedStatement.executeUpdate();
			System.out.println("Restaurant updated successfully!");
  
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	}

	@Override
	public void deleteRestaurant(int restaurantId) {

		 try (Connection connection = Dbconnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {

			 preparedStatement.setInt(1, restaurantId);
			 preparedStatement.executeUpdate();
			 System.out.println("Restaurant deleted successfully!");

	     } 
		 catch (SQLException e) {
	            e.printStackTrace();
	        }

	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		
		List<Restaurant> restaurantList= new ArrayList<Restaurant>();

		try (Connection connection = Dbconnection.getConnection();
	             Statement stmt = connection.createStatement();
	             ResultSet res = stmt.executeQuery(GET_ALL_QUERY)) {

	            while (res.next()) {
	                restaurantList.add(new Restaurant(
	                        res.getInt("restaurantId"),
	                        res.getString("name"),
	                        res.getString("address"),
	                        res.getString("phonenumber"),
	                        res.getString("cuisineType"),
	                        res.getTime("deliveryTime"),
	                        res.getInt("adminuserId"),
	                        res.getFloat("rating"),
	                        res.getString("imagePath")));
	            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurantList;

	}

}
