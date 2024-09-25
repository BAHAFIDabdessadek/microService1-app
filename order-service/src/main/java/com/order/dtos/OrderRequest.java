package com.order.dtos;

import lombok.*;


import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Builder @Setter @Getter
public class OrderRequest {
    private String orderNumber;
    private List<OrderLineItemsDto> orderLineItemsDtos;
}
