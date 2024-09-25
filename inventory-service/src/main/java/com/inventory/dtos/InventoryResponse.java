package com.inventory.dtos;

import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class InventoryResponse {

    private String skuCode;
    private boolean isInStock;
}
