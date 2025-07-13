package com.smartcoder.OrderService.external.client;

import com.smartcoder.OrderService.exception.CustomException;
import com.smartcoder.OrderService.external.request.PaymentRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*
    * This interface is used to communicate with the Payment Service.
    * It will be called by the Order Service.
 */
@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "PAYMENT-SERVICE/payment")
public interface PaymentService {

    @PostMapping
    ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);

    default void fallback(Exception e) {
        throw  new CustomException("Payment Service is not available", "UNAVAILABLE", 500);
    }
}
