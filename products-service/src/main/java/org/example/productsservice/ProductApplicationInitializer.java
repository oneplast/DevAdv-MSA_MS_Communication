package org.example.productsservice;

import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductApplicationInitializer implements ApplicationRunner {

    private final ProductJpaRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IntStream.rangeClosed(1, 5)
                .forEach(i -> {
                    Product product = Product.builder()
                            .name("PRODUCT_00%d".formatted(i))
                            .price(Math.abs(new Random().nextLong() % 1000))
                            .code(UUID.randomUUID().toString())
                            .amount(Math.abs(new Random().nextLong() % 10))
                            .build();

                    repository.save(product);
                });
    }
}
