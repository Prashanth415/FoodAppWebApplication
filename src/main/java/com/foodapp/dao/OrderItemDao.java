package com.foodapp.dao;
import com.foodapp.model.OrderItem;
import java.util.List;

public interface OrderItemDao {
    void addOrderItems(List<OrderItem> items);
    List<OrderItem> getItemsByOrderId(int orderId);
}

