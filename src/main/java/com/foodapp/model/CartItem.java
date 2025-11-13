package com.foodapp.model;

public class CartItem {
    private int menuId;
    private String itemname;
    private float price;
    private int quantity;
    private int restaurantId;


    public CartItem(int menuId, String itemname, float price, int quantity,int restaurantId) {
        this.menuId = menuId;
        this.itemname = itemname;
        this.price = price;
        this.quantity = quantity;
        this.restaurantId = restaurantId;
    }

    // Getters and setters
    public int getMenuId() { return menuId; }
    public void setMenuId(int menuId) { this.menuId = menuId; }

    public String getItemname() { return itemname; }
    public void setItemname(String itemname) { this.itemname = itemname; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public float getTotalPrice() {
        return price * quantity;
    }
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
	
}
