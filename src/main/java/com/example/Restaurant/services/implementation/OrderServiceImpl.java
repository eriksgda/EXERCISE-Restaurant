package com.example.Restaurant.services.implementation;

import com.example.Restaurant.Scopes.OrderGenerator;
import com.example.Restaurant.models.Order;
import com.example.Restaurant.repositories.OrderRepository;
import com.example.Restaurant.services.OrderService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Getter
@Setter
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final ObjectProvider<OrderGenerator> generatorProvider;

    @Autowired
    public OrderServiceImpl(OrderRepository repository, ObjectProvider<OrderGenerator> generatorProvider) {
        this.repository = repository;
        this.generatorProvider = generatorProvider;
    }

    @Override
    public Order createOrder(String description) {
        Order newOrder = this.generatorProvider.getObject().generateOrder(description);
        return this.repository.save(newOrder);
    }

    @Override
    public List<Order> getAllOrders() {
        return this.repository.findAll();
    }

    @PostConstruct
    public void init() {
        System.out.println("Order service initialized.");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Order Service destroyed.");
    }
}
