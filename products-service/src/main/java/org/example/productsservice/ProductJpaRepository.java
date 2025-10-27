package org.example.productsservice;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByCode(String code);
}
