package com.molvenolakeresort.repositories.restaurant.stock;

import com.molvenolakeresort.models.restaurant.stock.IngredientMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ingredient_MenuItemRepository extends JpaRepository<IngredientMenuItem, Long> {
}
