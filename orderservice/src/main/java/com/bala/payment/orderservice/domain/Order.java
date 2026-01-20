package com.bala.payment.orderservice.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Getter
    @Id
    private UUID id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    protected Order() {}

    public Order(String userId, BigDecimal amount, String currency) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.status = OrderStatus.PENDING;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public void markCompleted() {
        this.status = OrderStatus.COMPLETED;
        this.updatedAt = Instant.now();
    }

    public void markFailed() {
        this.status = OrderStatus.FAILED;
        this.updatedAt = Instant.now();
    }

}
