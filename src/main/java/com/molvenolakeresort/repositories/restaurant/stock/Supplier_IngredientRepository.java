package com.molvenolakeresort.repositories.restaurant.stock;

import com.molvenolakeresort.models.restaurant.stock.SupplierIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Supplier_IngredientRepository extends JpaRepository<SupplierIngredient, Long> {
}
