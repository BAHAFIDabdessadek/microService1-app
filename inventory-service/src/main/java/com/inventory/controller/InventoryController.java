package com.inventory.controller;


import com.inventory.dtos.InventoryResponse;
import com.inventory.service.IInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final IInventoryService iInventoryService;

    @GetMapping("/r")
    public List<InventoryResponse> isInStock(@RequestParam("sku-codes") List<String> skuCodes){
       return iInventoryService.isInStock(skuCodes);
    }

}
