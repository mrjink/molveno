package com.molvenolakeresort.repositories.restaurant.order;

import com.molvenolakeresort.models.restaurant.order.RestaurantInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantInvoiceRepository extends JpaRepository<RestaurantInvoice, Long> {
}
