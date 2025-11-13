package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.User;

public interface UserInterface {

	void addUser(User user);
	User getUser(int userId);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User> getAllUsers();
	User getUserByUsernameAndPassword(String username, String password);

}
