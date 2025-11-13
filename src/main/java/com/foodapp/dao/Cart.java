package com.foodapp.dao;

import java.util.Map;

import com.foodapp.model.CartItem;

public interface Cart {
	void addItem(int userId, CartItem item);
    void updateItem(int userId, CartItem item);
    void deleteItem(int userId, int menuId);
    Map<Integer, CartItem> getCartItemsByUserId(int userId);// menuId → Cart
	}
