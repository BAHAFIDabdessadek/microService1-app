package com.order.dtos;

import lombok.*;

import java.math.BigDecimal;

@Builder @AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class OrderLineItemsDto {
    private Long id ;
    private String skuCode;
    private BigDecimal price;
    private Integer quantite;
}
