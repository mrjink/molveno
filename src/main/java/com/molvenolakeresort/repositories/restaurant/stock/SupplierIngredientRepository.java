package com.molvenolakeresort.repositories.restaurant.stock;

import com.molvenolakeresort.models.restaurant.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierIngredientRepository extends JpaRepository<Stock, Long> {
}
