package org.example.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.orderservice.model.Orders;
import org.example.orderservice.model.dto.CreateOrderRequest;
import org.example.orderservice.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersApiController {

    private final OrdersService ordersService;

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody CreateOrderRequest orders) {
        return ResponseEntity.ok(ordersService.createOrder(orders));
    }

    @GetMapping("/{code}")
    public ResponseEntity<Orders> getOrder(@PathVariable String code) {
        return ResponseEntity.ok(ordersService.getOrder(code));
    }
}
