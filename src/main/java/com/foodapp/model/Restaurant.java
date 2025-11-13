package com.foodapp.model;

import java.sql.Time;

public class Restaurant {
	
	private int restaurantId;
	private String name;
	private String address;
	private String phonenumber;
	private String cuisineType;
	private Time deliveryTime;
	private int adminuserId;
	private float rating;
	private String imagepath;
	
	public Restaurant() {
		super();
	}

	public Restaurant(int restaurantId, String name, String address, String phonenumber, String cuisineType,
			Time deliveryTime, int adminuserId, float rating, String imagepath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminuserId = adminuserId;
		this.rating = rating;
		this.imagepath = imagepath;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public Time getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Time deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public int getAdminuserId() {
		return adminuserId;
	}

	public void setAdminuserId(int adminuserId) {
		this.adminuserId = adminuserId;
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
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address + ", phonenumber="
				+ phonenumber + ", cuisineType=" + cuisineType + ", deliveryTime=" + deliveryTime + ", adminuserId="
				+ adminuserId + ", rating=" + rating + ", imagepath=" + imagepath + "]";
	}
	
	
	
}
