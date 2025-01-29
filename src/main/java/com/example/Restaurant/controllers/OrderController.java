package com.example.Restaurant.controllers;

import com.example.Restaurant.Scopes.OrderProcessor;
import com.example.Restaurant.models.Order;
import com.example.Restaurant.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;
    private final OrderProcessor processor;

    @Autowired
    public OrderController(OrderService service, OrderProcessor processor) {
        this.service = service;
        this.processor = processor;
    }

    @PostMapping("/post")
    public ResponseEntity<?> createOrder(@RequestBody String description) {
        System.out.println("Processing request ID: " + this.processor.getRequestId() + " at: " + this.processor.getRequestTime());
        Order order = this.service.createOrder(description);

        return ResponseEntity.ok().body(order);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getOrders() {
        List<Order> orders = this.service.getAllOrders();

        return ResponseEntity.ok().body(orders);
    }
}
