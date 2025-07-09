package com.smartcoder.OrderService.service;

import com.smartcoder.OrderService.model.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
