package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Menu;

public interface MenuInterface {
	
	void addMenuItem(Menu menu);
    Menu getMenuItem(int menuId);
    void updateMenuItem(Menu menu);
    void deleteMenuItem(int menuId);
    List<Menu> getAllMenuItems();
    List<Menu> getAllMenuByRestaurantId(int restaurantId);


}
