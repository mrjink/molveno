package com.molvenolakeresort.repositories.restaurant.stock;

import com.molvenolakeresort.models.restaurant.stock.IngredientMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientMenuItemRepository extends JpaRepository<IngredientMenuItem, Long> {
}
