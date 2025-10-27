package org.example.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orderservice.model.Orders;
import org.example.orderservice.model.dto.CreateOrderRequest;
import org.example.orderservice.model.dto.ProductView;
import org.example.orderservice.repository.OrdersJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final RestTemplate restTemplate;
    private final OrdersJpaRepository repository;

    @Override
    public Orders createOrder(CreateOrderRequest request) {
        ProductView productView = restTemplate.getForObject("http://products-service/products/" + request.productCode(),
                ProductView.class);

        log.info("productView = {}", productView);

        Orders order = Orders.builder()
                .amount(request.amount())
                .targetCode(request.productCode())
                .totalPrice(productView.price() * request.amount())
                .build();

        return repository.save(order);
    }

    @Override
    public Orders getOrder(String code) {
        return repository.findByCode(code).orElseThrow();
    }
}
