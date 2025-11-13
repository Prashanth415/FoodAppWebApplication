package com.foodapp.model;

public class OrderItem {
    private int orderitemId;
    private int orderId;
    private int menuId;
    private int quantity;
    private float totalamount;
	
    public OrderItem(int orderitemId, int orderId, int menuId, int quantity, float totalamount) {
		super();
		this.orderitemId = orderitemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.totalamount = totalamount;
	}

	public OrderItem() {
		super();
	}

	public int getOrderitemId() {
		return orderitemId;
	}

	public void setOrderitemId(int orderitemId) {
		this.orderitemId = orderitemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}

    // Getters and setters
    // (all fields)
    
    
}
