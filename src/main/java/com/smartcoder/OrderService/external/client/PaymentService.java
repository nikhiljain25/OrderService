package com.smartcoder.OrderService.external.client;

import com.smartcoder.OrderService.external.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*
    * This interface is used to communicate with the Payment Service.
    * It will be called by the Order Service.
 */
@FeignClient(name = "PAYMENT-SERVICE/payment")
public interface PaymentService {

    @PostMapping
    ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);

}
