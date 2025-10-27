package org.example.orderservice.service;

import org.example.orderservice.model.Orders;
import org.example.orderservice.model.dto.CreateOrderRequest;

public interface OrdersService {

    Orders createOrder(CreateOrderRequest request);
    Orders getOrder(String code);
}
