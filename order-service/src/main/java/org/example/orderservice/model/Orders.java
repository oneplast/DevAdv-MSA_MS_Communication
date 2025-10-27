package org.example.orderservice.model;

import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    // 어떤 제품을 주문했는지, 제품 코드
    private String targetCode;

    private Long amount;
    private Long totalPrice;

    private LocalDateTime orderedAt;

    @Builder
    public Orders(String targetCode, Long amount, Long totalPrice) {
        this.code = UUID.randomUUID().toString();
        this.targetCode = targetCode;
        this.amount = amount;
        this.totalPrice = totalPrice;
        orderedAt = LocalDateTime.now();
    }
}
