package com.example.Restaurant.Scopes;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderProcessor {
    private final UUID requestId;
    private final LocalDateTime requestTime;

    @Autowired
    public OrderProcessor() {
        this.requestId = UUID.randomUUID();
        this.requestTime = LocalDateTime.now();
    }

    public UUID getRequestId() {
        return this.requestId;
    }

    public LocalDateTime getRequestTime() {
        return this.requestTime;
    }

    @PostConstruct
    public void init() {
        System.out.println("Starting processing of order: " + this.requestId + " at: " + this.requestTime);
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Finishing processing of order: " + this.requestId + " at: " + this.requestTime);
    }
}
