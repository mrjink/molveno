package com.molvenolakeresort.repositories.restaurant.order;

import com.molvenolakeresort.models.restaurant.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
