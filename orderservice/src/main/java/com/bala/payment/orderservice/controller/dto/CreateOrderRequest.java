package com.bala.payment.orderservice.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateOrderRequest {

    private String userId;
    private BigDecimal amount;
    private String currency;

    // getters & setters
}
