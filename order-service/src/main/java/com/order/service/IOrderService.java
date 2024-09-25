package com.order.service;

import com.order.dtos.OrderRequest;

public interface IOrderService {
    public void placeOrder(OrderRequest orderRequest);
    }
