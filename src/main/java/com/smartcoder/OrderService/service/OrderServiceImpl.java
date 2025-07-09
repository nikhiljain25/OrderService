package com.smartcoder.OrderService.service;

import com.smartcoder.OrderService.entity.Order;
import com.smartcoder.OrderService.external.client.ProductService;
import com.smartcoder.OrderService.model.OrderRequest;
import com.smartcoder.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;
    @Override
    public long placeOrder(OrderRequest orderRequest) {
        log.info("Placing order request: {}", orderRequest);
        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
        log.info("Creating Order with status CREATED");
        Order oder = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .productId(orderRequest.getProductId())
                .orderStatus("CREATED") // Assuming "CREATED" is the initial status
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        oder = orderRepository.save(oder);
        log.info("Order placed successfully with ID: {}", oder.getId());
        return oder.getId();
    }
}
