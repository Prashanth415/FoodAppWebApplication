package com.foodapp.daoimplementation;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.foodapp.dao.UserInterface;
import com.foodapp.model.User;
import com.util.Dbconnection;

public class UserDaoIml implements UserInterface{
	
	private static String INSERT_USER_QUERY="INSERT into `user` (`name`,`username`,`password`,`email`,`phonenumber`,`address`,`role`,`createDate`,`lastLoginDate`) values (?,?,?,?,?,?,?,?,?)";
	private static String GET_USER="SELECT * FROM `user` WHERE `userId`=?";
	private static final String UPDATE_USER = "UPDATE `user` SET `name`=?, `username`=?, `password`=?, `email`=?, `phonenumber`=?, `address`=?, `role`=? WHERE `userId`=?";
	private static String DELETE_USER ="DELETE FROM `user` WHERE `userId`=?";
	private static String GET_ALL_USERS ="SELECT * FROM `user`";
	@Override
	public void addUser(User user) {
		
		try(Connection connection=Dbconnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY);) 
		{
			preparedStatement.setString(1,user.getName());
			preparedStatement.setString(2,user.getUsername());
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setString(4,user.getEmail());
			preparedStatement.setString(5,user.getPhonenumber());
			preparedStatement.setString(6,user.getAddress());
			preparedStatement.setString(7,user.getRole());
			preparedStatement.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
			preparedStatement.setTimestamp(9,new Timestamp(System.currentTimeMillis()));
			preparedStatement.executeUpdate();
			System.out.println("User added successfully!");
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
	}

	@Override
	public User getUser(int userId) {
		User user=null;
		try(Connection connection=Dbconnection.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(GET_USER);)
		{
			
			preparedStatement.setInt(1, userId);
			ResultSet res=preparedStatement.executeQuery();
			if (res.next()) {  
	            user = new User(
	                res.getInt("userId"),
	                res.getString("name"),
	                res.getString("username"),
	                res.getString("password"),
	                res.getString("email"),
	                res.getString("phonenumber"),
	                res.getString("address"),
	                res.getString("role"),
	                res.getTimestamp("createDate"),
	                res.getTimestamp("lastLoginDate")
	            );
	        } else {
	            System.out.println("User not found in DB!");
	        }
	    } 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return user;
	}
	@Override
	public void updateUser(User user) {

		try(Connection connection=Dbconnection.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_USER);)
		{
			
			preparedStatement.setString(1,user.getName());
			preparedStatement.setString(2,user.getUsername());
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setString(4,user.getEmail());
			preparedStatement.setString(5,user.getPhonenumber());
			preparedStatement.setString(6,user.getAddress());
			preparedStatement.setString(7,user.getRole());
			preparedStatement.setInt(8, user.getUserId());

			preparedStatement.executeUpdate();
			System.out.println("User updated successfully!");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	  
	}

	@Override
	public void deleteUser(int userId) {

		try(Connection connection=Dbconnection.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USER);){
			
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			System.out.println("User deleted successfully!");

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		
		ArrayList<User> userList= new ArrayList<User>();
		
		try(Connection connection=Dbconnection.getConnection();
			Statement statement =connection.createStatement();)
		{
			
			ResultSet res= statement.executeQuery(GET_ALL_USERS);
			while(res.next()) {
				int userId=res.getInt("userId");
				String name=res.getString("name");
				String username=res.getString("username");
				String password =res.getString("password");
				String email=res.getString("email");
				String phonenumber=res.getString("phonenumber");
				String address=res.getString("address");
				String role=res.getString("role");
				
				User user=new User(userId, name, username, password, email, phonenumber, address, role, null, null);
				
				userList.add(user);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
	    User user = null;
	    String sql = "SELECT * FROM user WHERE username=? AND password=?";
	    
	    try (Connection conn = Dbconnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        
	        ps.setString(1, username);
	        ps.setString(2, password);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            user = new User(
	                rs.getInt("userId"),
	                rs.getString("name"),
	                rs.getString("username"),
	                rs.getString("password"),
	                rs.getString("email"),
	                rs.getString("phonenumber"),
	                rs.getString("address"),
	                rs.getString("role"),
	                rs.getTimestamp("createDate"),
	                rs.getTimestamp("lastLoginDate")
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return user;
	}


}
