package com.smartcoder.OrderService.repository;

import com.smartcoder.OrderService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long> {

    // This interface will automatically provide CRUD operations for Order entity
    // Additional custom query methods can be defined here if needed
}
