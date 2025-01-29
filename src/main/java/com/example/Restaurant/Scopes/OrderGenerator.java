package com.example.Restaurant.Scopes;

import com.example.Restaurant.models.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Scope("prototype")
public class OrderGenerator {
    public Order generateOrder(String description) {
        Order newOrder = new Order();
        newOrder.setId(UUID.randomUUID());
        newOrder.setDescription(description);
        newOrder.setStatus("CREATED");
        newOrder.setCreationDate(LocalDateTime.now());

        return newOrder;
    }
}
