package com.foodapp.model;

import java.util.Date;

public class Order {
    private int orderId;
    private int restaurantId;
    private int userId;
    private Date orderDate;
    private float totalamount;
    private String status;
    private String paymentmode;
	
    public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public float getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	
	public Order(int orderId, int restaurantId, int userId, Date orderDate, float totalamount, String status,
			String paymentmode) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmode = paymentmode;
	}
	public Order() {
		super();
	}
	
	

    // Getters and setters
    // (all fields)
}
