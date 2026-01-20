package com.bala.payment.orderservice.domain;

public enum OrderStatus {

    PENDING,     // order created, payment not done
    COMPLETED,   // payment successful
    FAILED      // payment failed

}
