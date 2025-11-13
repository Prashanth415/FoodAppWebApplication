package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Restaurant;

public interface RestaurantInterface {

	void addRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(int restaurantId);
	void updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int restaurantId);
	List<Restaurant> getAllRestaurants();
	

	}

