package com.molvenolakeresort.repositories.restaurant.stock;

import com.molvenolakeresort.models.restaurant.stock.SupplyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyOrderRepository extends JpaRepository<SupplyOrder, Long> {
}
