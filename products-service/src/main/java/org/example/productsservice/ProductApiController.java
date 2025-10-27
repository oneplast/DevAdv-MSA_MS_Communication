package org.example.productsservice;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductApiController {

    private final ProductJpaRepository productJpaRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productJpaRepository.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Product> getProductByCode(@PathVariable String code) {
        log.info("code: {}", code);
        return ResponseEntity.ok(productJpaRepository.findByCode(code).orElseThrow());
    }
}
