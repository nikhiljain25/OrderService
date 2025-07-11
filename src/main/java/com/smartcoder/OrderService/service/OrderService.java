package com.smartcoder.OrderService.service;

import com.smartcoder.OrderService.model.OrderRequest;
import com.smartcoder.OrderService.model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}
