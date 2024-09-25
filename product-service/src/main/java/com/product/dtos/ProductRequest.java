package com.product.dtos;

import lombok.*;

import java.math.BigDecimal;
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductRequest {
    private String name;
    private String description;

    private BigDecimal price;
}
