package com.molvenolakeresort.repositories.restaurant.stock;


import com.molvenolakeresort.models.restaurant.stock.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
