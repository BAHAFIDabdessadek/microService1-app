package com.inventory.service;

import com.inventory.dtos.InventoryResponse;

import java.util.List;

public interface IInventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode);
}
