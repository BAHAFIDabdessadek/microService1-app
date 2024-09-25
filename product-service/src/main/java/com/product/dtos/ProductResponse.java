package com.product.dtos;

import lombok.*;

import java.math.BigDecimal;

@Builder @Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String Description;

    private BigDecimal price;
}
