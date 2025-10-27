package org.example.orderservice.model.dto;

public record ProductView(
        String code,
        Long price,
        Long amount
) {
}
