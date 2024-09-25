package com.order.controller;

import com.order.dtos.OrderRequest;
import com.order.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    private  final IOrderService iOrderService;

    @PostMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody OrderRequest orderRequest){
        iOrderService.placeOrder(orderRequest);
    }


}
