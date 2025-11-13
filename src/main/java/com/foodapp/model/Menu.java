package com.foodapp.model;

public class Menu {
	
	private int menuId;
	private int restaurantId;
	private String itemname;
	private String description;
	private float price;
	private String isavailable;
	private float rating;
	private String imagepath;
	
	
	public Menu() {
		super();
	}


	public Menu(int menuId, int restaurantId, String itemname, String description, float price,
			String isavailable, float rating, String imagepath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isavailable = isavailable;
		this.rating = rating;
		this.imagepath = imagepath;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String isIsavailable() {
		return isavailable;
	}


	public void setIsavailable(String isavailable) {
		this.isavailable = isavailable;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public String getImagepath() {
		return imagepath;
	}


	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}


	@Override
	public String toString() {
		return "Menu [ "+" restaurantId=" + restaurantId + ", itemname=" + itemname + ", description="
				+ description + ", price=" + price + ", isavailable=" + isavailable + ", rating=" + rating
				+ ", imagepath=" + imagepath + "]";
	}
	
	
	
	

}
