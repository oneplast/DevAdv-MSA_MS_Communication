package org.example.orderservice.configuration;

import org.example.orderservice.model.dto.ProductView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products-service")
public interface ProductClient {

    @GetMapping("/products/{code}")
    ProductView getProductByCode(@PathVariable String code);
}
