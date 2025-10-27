package org.example.orderservice.model.dto;

public record CreateOrderRequest(
        String productCode,
        Long amount
) {
}
