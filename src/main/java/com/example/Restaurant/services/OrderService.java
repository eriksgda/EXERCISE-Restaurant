package com.example.Restaurant.services;

import com.example.Restaurant.models.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(String description);
    List<Order> getAllOrders();
}
