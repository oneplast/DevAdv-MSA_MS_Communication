package org.example.orderservice.repository;

import java.util.Optional;
import org.example.orderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersJpaRepository extends JpaRepository<Orders, Long> {

    Optional<Orders> findByCode(String code);
}
