package com.bala.payment.orderservice.service;

import com.bala.payment.orderservice.domain.Order;
import com.bala.payment.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public UUID createOrder(String userId, BigDecimal amount, String currency) {
        Order order = new Order(userId, amount, currency);
        orderRepository.save(order);
        return order.getId();
    }
}
