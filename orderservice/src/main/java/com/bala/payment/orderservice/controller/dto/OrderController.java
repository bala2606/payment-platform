package com.bala.payment.orderservice.controller.dto;

import com.bala.payment.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Map<String, UUID>> createOrder(
            @RequestBody CreateOrderRequest request) {

        UUID orderId = orderService.createOrder(
                request.getUserId(),
                request.getAmount(),
                request.getCurrency()
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("orderId", orderId));
    }
}
