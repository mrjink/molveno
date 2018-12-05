package com.molvenolakeresort.repositories.restaurant.stock;

import com.molvenolakeresort.models.restaurant.stock.Ingredient_MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ingredient_MenuItemRepository extends JpaRepository<Ingredient_MenuItem, Long> {
}
